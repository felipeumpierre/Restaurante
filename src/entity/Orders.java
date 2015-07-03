package entity;

/**
 *
 * @author Felipe
 */
public class Orders {
   protected int id;
   protected int tableId;
   protected int waiterId;
   
   public Orders(int tableId, int waiterId) {
      this.setTableId(tableId);
      this.setWaiterId(waiterId);
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getTableId() {
      return tableId;
   }

   public void setTableId(int tableId) {
      this.tableId = tableId;
   }

   public int getWaiterId() {
      return waiterId;
   }

   public void setWaiterId(int waiterId) {
      this.waiterId = waiterId;
   }
}
