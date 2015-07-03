/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Felipe
 */
public interface OrdersProductDao {
   static final String DELETE = "DELETE FROM restaurante.orders_product WHERE id = ?;";
   static final String FIND_ALL_PRODUCTS_FROM_ORDERS = "SELECT * FROM restaurante.orders_product WHERE orders_id = ? ORDER BY id;";
   static final String FIND_BY_ID = "SELECT * FROM restaurante.orders_product WHERE id = ?;";
   static final String INSERT = "INSERT INTO restaurante.orders_product (orders_id, product_id) VALUES(?, ?);";
   static final String FIND_ALL_ORDERS_FROM_PRODUCT = "SELECT * FROM restaurante.orders_product WHERE product_id = ? ORDER BY id;";
}
