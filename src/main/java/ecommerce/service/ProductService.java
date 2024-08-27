package ecommerce.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ecommerce.DAO.ProductDao;
import ecommerce.model.Product;
@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductDao productDao;
	public boolean saveProduct(Product prd) {
		return this.productDao.addProduct(prd);
	}
	public boolean deleteProduct(Product prd) {
		return this.productDao.deleteProduct(prd);
	}
	public List<Product> getAllProduct(){
		return this.productDao.listOfProduct();
	}
	public Product getProduct(int productId) {
		Product prd = this.productDao.getProduct(productId);
		return prd;
	}
	public boolean updateProduct(Product prd) {
		return this.productDao.updateProduct(prd);
	}
	public List<Product> getAllProductByCategoryId(int categoryId){
		return this.productDao.listOfProductBasedOnCategoryId(categoryId);
	}
}
