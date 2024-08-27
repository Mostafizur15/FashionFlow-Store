package ecommerce.test;

import static org.junit.Assert.*;

import org.hibernate.Hibernate;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ecommerce.DAO.CategoryDao;
import ecommerce.DAO.ProductDao;
import ecommerce.model.Category;
import ecommerce.model.Product;

public class CatJunitTest {

	static CategoryDao categoryDao;
	static ProductDao productDao;
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("ecommerce");
		context.refresh();
        categoryDao = context.getBean("categoryDao1", CategoryDao.class);
		productDao = context.getBean("productDao", ProductDao.class);
	}

	/*
	 * @Test public void addCategoryTest() { category category = new category();
	 * category.setCategoryName("T-shirt"); category.setCategoryDesc("Premium");
	 * 
	 * assertTrue("Preblem during add Category",categoryDao.addCategory(category));
	 * }
	 * 
	 * @Test public void updateCategoryTest() { category category = new category();
	 * category.setCategoryId(16); category.setCategoryName("T-shirt");
	 * category.setCategoryDesc("Slightly Premium");
	 * 
	 * assertTrue("Preblem during add Category",categoryDao.updateCategory(category)
	 * ); }
	 * 
	 * @Test public void addProductTest() { product product = new product();
	 * product.setPrice(420); product.setProductDesc("Premium");
	 * product.setCategoryId(16); product.setStock(32); product.setSupplierId(122);
	 * product.setProductName("Tshirt");
	 * assertTrue("Preblem during add Category",productDao.addProduct(product)); }
	 */
	@Test
	public void getCategoryTest() {
		try {
			Category cat=(Category)categoryDao.getCategory(16);
			System.out.println(cat.getCategoryName());
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("ERROR");
		}
//		assertTrue("Preblem during add Category",categoryDao.getCategory(16));
	}

}