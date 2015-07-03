/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Felipe
 */
public class OrdersProduct {
   protected int id;
   protected int ordersId;
   protected int productId;

   public OrdersProduct(int ordersId, int productId) {
      this.setOrdersId(ordersId);
      this.setProductId(productId);
   }
   
   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getOrdersId() {
      return ordersId;
   }

   public void setOrdersId(int ordersId) {
      this.ordersId = ordersId;
   }

   public int getProductId() {
      return productId;
   }

   public void setProductId(int productId) {
      this.productId = productId;
   }
}