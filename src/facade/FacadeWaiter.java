package facade;

import java.util.List;

import dao.WaiterDaoImpl;
import entity.Waiter;

public class FacadeWaiter {

   protected WaiterDaoImpl waiter;

   public FacadeWaiter() {
      waiter = new WaiterDaoImpl();
   }

   public Waiter insert(String name, String cpf, double salary) {
      Waiter w = new Waiter(name, cpf, salary);
      waiter.insert(w);

      return w;
   }

   public Waiter update(String name, String cpf, double salary) {
      Waiter w = waiter.findByCpf(cpf);
      w.setName(name);
      w.setSalary(salary);

      waiter.update(w);

      return w;
   }

   public void delete(String cpf) {
      Waiter w = waiter.findByCpf(cpf);

      waiter.delete(w);
   }

   public List<Waiter> listAll() {
      return waiter.findAll();
   }

   public Waiter listByCpf(String cpf) {
      return waiter.findByCpf(cpf);
   }
   
   public Waiter listById(int id) {
      return waiter.findById(id);
   }
}
