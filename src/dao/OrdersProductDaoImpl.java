/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.Dao.close;
import static dao.OrdersProductDao.*;
import entity.Orders;
import entity.OrdersProduct;

import entity.Product;
import facade.FacadeOrders;
import facade.FacadeProduct;
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
public class OrdersProductDaoImpl extends Dao implements OrdersProductDao {
   private PreparedStatement ps;
   private Connection connect;
   private DateFormat dateFormat;

   public OrdersProductDaoImpl() {
      dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   }

   public int insert(Orders o, Product p) {
      try {
         connect = getConnection();
         ps = connect.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
         ps.setInt(1, o.getId());
         ps.setInt(2, p.getId());

         int result = ps.executeUpdate();

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

   public int delete(OrdersProduct op) {
      try {
         connect = getConnection();
         ps = connect.prepareStatement(DELETE);
         ps.setInt(1, op.getId());

         return ps.executeUpdate();
      } catch (SQLException e) {
         throw new RuntimeException(e);
      } finally {
         close(ps);
         close(connect);
      }
   }

   public List<Product> findAllProductsFromOrders(Orders o) {
      try {
         connect = getConnection();
         ps = connect.prepareStatement(FIND_ALL_PRODUCTS_FROM_ORDERS);
         ps.setInt(1, o.getId());

         ResultSet rs = ps.executeQuery();
         List<Product> p = new ArrayList<Product>();

         FacadeProduct facadeProduct = new FacadeProduct();
         
         while (rs.next()) {
            p.add(facadeProduct.listById(rs.getInt("product_id")));
         }

         return p;
      } catch (SQLException e) {
         throw new RuntimeException(e);
      } finally {
         close(ps);
         close(connect);
      }
   }

   public List<Orders> findAllOrdersFromProduct(Product p) {
      try {
         connect = getConnection();
         ps = connect.prepareStatement(FIND_ALL_ORDERS_FROM_PRODUCT);
         ps.setInt(1, p.getId());

         ResultSet rs = ps.executeQuery();
         List<Orders> o = new ArrayList<Orders>();

         FacadeOrders facadeOrders = new FacadeOrders();

         while (rs.next()) {
            o.add(facadeOrders.listById(rs.getInt("orders_id")));
         }
         
         return o;
      } catch (SQLException e) {
         throw new RuntimeException(e);
      } finally {
         close(ps);
         close(connect);
      }
   }
   
   public OrdersProduct findById(int id) {
      try {
         connect = getConnection();
         ps = connect.prepareStatement(FIND_BY_ID);
         ps.setInt(1, id);

         ResultSet rs = ps.executeQuery();

         if (rs.next()) {
            OrdersProduct orders = new OrdersProduct(rs.getInt("orders_id"), rs.getInt("product_id"));
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
