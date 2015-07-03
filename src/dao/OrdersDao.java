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
public interface OrdersDao {
   static final String DELETE = "DELETE FROM restaurante.orders WHERE id = ?;";
   static final String FIND_ALL_TABLES_FROM_WAITER = "SELECT * FROM restaurante.orders WHERE waiter_id = ? ORDER BY id DESC;";
   static final String FIND_BY_ID = "SELECT * FROM restaurante.orders WHERE id = ?;";
   static final String FIND_BY_TABLE_ID = "SELECT * FROM restaurante.orders WHERE table_id = ? ORDER BY id DESC LIMIT 1;";
   static final String INSERT = "INSERT INTO restaurante.orders (table_id, waiter_id, created_at) VALUES(?, ?, ?);";
   static final String FIND_ALL_WAITERS_FROM_TABLE = "SELECT * FROM restaurante.orders WHERE table_id = ? ORDER BY id DESC;";
}
