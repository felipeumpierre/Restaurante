package facade;

import dao.OrdersProductDaoImpl;
import entity.Orders;
import entity.OrdersProduct;
import entity.Product;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class FacadeOrdersProduct {
   protected OrdersProductDaoImpl ordersProduct;
   protected FacadeOrders facadeOrders;
   protected FacadeProduct facadeProduct;
   
   public FacadeOrdersProduct() {
      ordersProduct = new OrdersProductDaoImpl();
      facadeOrders = new FacadeOrders();
      facadeProduct = new FacadeProduct();
   }
   
   public void insert(int ordersId, int productId) {
      Orders o = facadeOrders.listById(ordersId);
      Product p = facadeProduct.listById(productId);
      
      ordersProduct.insert(o, p);
   }
   
   public void delete(int ordersProductId) {
      OrdersProduct op = ordersProduct.findById(ordersProductId);
      
      ordersProduct.delete(op);
   }
   
   public OrdersProduct listById(int ordersProductId) {
      return ordersProduct.findById(ordersProductId);
   }
   
   public List<Orders> listOrdersByProductId(int productId) {
      return ordersProduct.findAllOrdersFromProduct(facadeProduct.listById(productId));
   }
   
   public List<Product> listProductByOrdersId(int ordersId) {
      return ordersProduct.findAllProductsFromOrders(facadeOrders.listById(ordersId));
   }
}