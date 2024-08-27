package ecommerce.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ecommerce.DAO.SupplierDao;
import ecommerce.model.Supplier;


public class SupplierJunit {

	static SupplierDao supplierDao;
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("ecommerce");//artif id
		context.refresh();
		supplierDao = context.getBean("supplierDao", SupplierDao.class);
	}
	@Test
	public void addSupplierTest() {
		Supplier supplier = new Supplier();
		supplier.setSupplierName("Raju LTD.");
		supplier.setSupplierAddress("Dhaka");
		assertTrue("Preblem during add Supplier",supplierDao.addSupplier(supplier));
	}
}
