/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.OrdersDaoImpl;
import entity.Orders;
import entity.Table;
import entity.Waiter;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class FacadeOrders {
   protected OrdersDaoImpl orders;
   protected FacadeTable facadeTable;
   protected FacadeWaiter facadeWaiter;
   
   public FacadeOrders() {
      orders = new OrdersDaoImpl();
      facadeTable = new FacadeTable();
      facadeWaiter = new FacadeWaiter();
   }
   
   public int insert(int tableId, int waiterId) {
      Table t = facadeTable.listById(tableId);
      Waiter w = facadeWaiter.listById(waiterId);
      
      int ordersId = orders.insert(t, w);
      
      return ordersId;
   }
   
   public void delete(int id) {
      Orders o = orders.findById(id);
      
      orders.delete(o);
   }
   
   public Orders listById(int id) {
      return orders.findById(id);
   }
   
   public Orders listByTableId(int id) {
      return orders.findByTableId(id);
   }
   
   public List<Waiter> listWaiters(int tableId) {
      Table t = facadeTable.listById(tableId);
      return orders.findAllWaitersFromTable(t);
   }
   
   public List<Table> listTables(int waiterId) {
      Waiter w = facadeWaiter.listById(waiterId);
      return orders.findAllTablesFromWaiter(w);
   }
}
