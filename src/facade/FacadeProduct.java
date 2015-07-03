package facade;

import java.util.List;

import dao.ProductDaoImpl;
import entity.Product;

public class FacadeProduct {

   protected ProductDaoImpl product;

   public FacadeProduct() {
      product = new ProductDaoImpl();
   }

   public Product insert(int code, String name, double price) {
      Product p = new Product(code, name, price);
      product.insert(p);

      return p;
   }

   public Product update(int code, String name, double price) {
      Product p = product.findByCode(code);
      p.setName(name);
      p.setPrice(price);
      product.update(p);

      return p;
   }

   public void delete(int code) {
      Product p = product.findByCode(code);

      product.delete(p);
   }

   public List<Product> listAll() {
      return product.findAll();
   }

   public Product listByName(String name) {
      return product.findByName(name);
   }

   public Product listByCode(int code) {
      return product.findByCode(code);
   }
   
   public Product listById(int id) {
      return product.findById(id);
   }
}
