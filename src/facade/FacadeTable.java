package facade;

import java.util.List;

import dao.TableDaoImpl;
import entity.Table;

public class FacadeTable {

   protected TableDaoImpl table;

   public FacadeTable() {
      table = new TableDaoImpl();
   }

   public Table insert(int number, int capacity) {
      Table t = new Table(number, capacity);
      table.insert(t);

      return t;
   }

   public Table update(int number, int capacity) {
      Table t = table.findByNumber(number);
      t.setCapacity(capacity);
      table.update(t);

      return t;
   }

   public void delete(int number) {
      Table t = table.findByNumber(number);

      table.delete(t);
   }

   public List<Table> listAll() {
      return table.findAll();
   }

   public Table listByNumber(int number) {
      return table.findByNumber(number);
   }
}
