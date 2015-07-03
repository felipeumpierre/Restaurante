/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.Dao.close;
import static dao.OrdersDao.DELETE;
import static dao.OrdersDao.FIND_ALL_TABLES_FROM_WAITER;
import static dao.OrdersDao.FIND_BY_ID;
import static dao.OrdersDao.INSERT;
import entity.Orders;

import entity.Product;
import entity.Table;
import entity.Waiter;
import facade.FacadeTable;
import facade.FacadeWaiter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class OrdersDaoImpl extends Dao implements OrdersDao {

   private PreparedStatement ps;
   private Connection connect;
   private DateFormat dateFormat;

   public OrdersDaoImpl() {
      dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   }

   public int insert(Table t, Waiter w) {
      try {
         connect = getConnection();
         ps = connect.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
         ps.setInt(1, t.getId());
         ps.setInt(2, w.getId());
         ps.setString(3, this.dateFormat.format(new Date()));

         int result = ps.executeUpdate();

         if (result == 0) {
            throw new SQLException("Creating failed, no rows affected.");
         }

         try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
            if (generatedKeys.next()) {
               return generatedKeys.getInt(1);
            } else {
               throw new SQLException("Creating failed, no ID obtained.");
            }
         }
      } catch (SQLException e) {
         throw new RuntimeException(e);
      } finally {
         close(ps);
         close(connect);
      }
   }

   public int delete(Orders o) {
      try {
         connect = getConnection();
         ps = connect.prepareStatement(DELETE);
         ps.setInt(1, o.getId());

         return ps.executeUpdate();
      } catch (SQLException e) {
         throw new RuntimeException(e);
      } finally {
         close(ps);
         close(connect);
      }
   }

   public List<Table> findAllTablesFromWaiter(Waiter w) {
      try {
         connect = getConnection();
         ps = connect.prepareStatement(FIND_ALL_TABLES_FROM_WAITER);
         ps.setInt(1, w.getId());

         ResultSet rs = ps.executeQuery();
         List<Table> t = new ArrayList<Table>();

         FacadeTable facadeTable = new FacadeTable();

         while (rs.next()) {
            t.add(facadeTable.listByNumber(rs.getInt("waiter_id")));
         }

         return t;
      } catch (SQLException e) {
         throw new RuntimeException(e);
      } finally {
         close(ps);
         close(connect);
      }
   }

   public List<Waiter> findAllWaitersFromTable(Table t) {
      try {
         connect = getConnection();
         ps = connect.prepareStatement(FIND_ALL_WAITERS_FROM_TABLE);
         ps.setInt(1, t.getId());

         ResultSet rs = ps.executeQuery();
         List<Waiter> w = new ArrayList<Waiter>();

         FacadeWaiter facadeWaiter = new FacadeWaiter();

         while (rs.next()) {
            w.add(facadeWaiter.listById(rs.getInt("waiter_id")));
         }

         return w;
      } catch (SQLException e) {
         throw new RuntimeException(e);
      } finally {
         close(ps);
         close(connect);
      }
   }

   public Orders findById(int id) {
      try {
         connect = getConnection();
         ps = connect.prepareStatement(FIND_BY_ID);
         ps.setInt(1, id);

         ResultSet rs = ps.executeQuery();

         if (rs.next()) {
            Orders orders = new Orders(rs.getInt("table_id"), rs.getInt("waiter_id"));
            orders.setId(rs.getInt("id"));

            return orders;
         } else {
            return null;
         }
      } catch (SQLException e) {
         throw new RuntimeException(e);
      } finally {
         close(ps);
         close(connect);
      }
   }
   
   public Orders findByTableId(int id) {
      try {
         connect = getConnection();
         ps = connect.prepareStatement(FIND_BY_TABLE_ID);
         ps.setInt(1, id);

         ResultSet rs = ps.executeQuery();

         if (rs.next()) {
            Orders orders = new Orders(rs.getInt("table_id"), rs.getInt("waiter_id"));
            orders.setId(rs.getInt("id"));

            return orders;
         } else {
            return null;
         }
      } catch (SQLException e) {
         throw new RuntimeException(e);
      } finally {
         close(ps);
         close(connect);
      }
   }
}
