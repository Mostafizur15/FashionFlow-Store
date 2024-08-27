package ecommerce.DAO;

import java.util.List;

import ecommerce.model.Product;


public interface ProductDao {
	public boolean addProduct(Product prod);
	public boolean deleteProduct(Product prod);
	public boolean updateProduct(Product prod);
	public List<Product> listOfProduct();
	public List<Product> listOfProductBasedOnCategoryId(int categoryId);
	public Product getProduct(int prodId);
}
