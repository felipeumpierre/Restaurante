package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Dao {

   private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
   private static final String DB_URL = "jdbc:mysql://localhost:3306/restaurante";
   private static final String ID = "root";
   private static final String PASS = "";

   public Connection getConnection() {
      try {
         Class.forName(DRIVER_NAME);

         return DriverManager.getConnection(DB_URL, ID, PASS);
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   public static void close(Connection con) {
      if (con != null) {
         try {
            con.close();
         } catch (SQLException e) {
            throw new RuntimeException(e);
         }
      }
   }

   public static void close(Statement stmt) {
      if (stmt != null) {
         try {
            stmt.close();
         } catch (SQLException e) {
            throw new RuntimeException(e);
         }
      }
   }
}
