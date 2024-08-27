package ecommerce.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ecommerce.DAO.UserDao;
import ecommerce.model.UserDetails;

public class UserJunit {
	static UserDao userDao;
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("ecommerce");//artif id
		context.refresh();
		userDao = context.getBean("userDao", UserDao.class);
	}
	@Test
	public void addSupplierTest() {
		UserDetails user = new UserDetails();
		user.setCustomerName("Razib");
		user.setCustomerAddr("Gazipur");
		user.setEnabled(true);
		user.setPassword("asdf12");
		user.setRole("Admin");
		user.setUserName("FORHAD");
		assertTrue("Preblem during add Supplier",userDao.registerUser(user));
	}

}
