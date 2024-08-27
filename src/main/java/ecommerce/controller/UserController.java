package ecommerce.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import ecommerce.model.Product;
import ecommerce.service.ProductService;

@Controller
public class UserController {

	@Autowired
    private ProductService ecomProductService;
	@RequestMapping("/userHome")
	public String showUserHome(Model m, HttpSession session) {
		System.out.println("User Home is it");
		m.addAttribute("pageInfo", "User Home");
		List<Product> productList = ecomProductService.getAllProduct();
		m.addAttribute("listOfProduct", productList);
		return "userHome";
	}
	@RequestMapping("/adminHome")
	public String showAdminHome(Model m, HttpSession session) {
	    System.out.println("Admin Home is being accessed");  // Debug log
	    m.addAttribute("pageInfo", "Admin Home");
	    List<Product> productList = ecomProductService.getAllProduct();
	    m.addAttribute("listOfProduct", productList);
	    return "adminHome";
	}
	@RequestMapping("/login_success")
	public String loginCheck(Model m, HttpSession session) {
		String page="";
		boolean loggedIn=false;
		SecurityContext securitycontext = SecurityContextHolder.getContext();
		Authentication authentication = securitycontext.getAuthentication();
		
		String userName=authentication.getName();
		
		Collection<GrantedAuthority> roles= (Collection<GrantedAuthority>)authentication.getAuthorities();
		for(GrantedAuthority role:roles) {
			session.setAttribute("role", role.getAuthority());
			List<Product> listOfProduct=this.ecomProductService.getAllProduct();
			m.addAttribute("listOfProduct", listOfProduct);
			
			if(role.getAuthority().equals("ROLE_ADMIN")) {
				loggedIn=true;
				page="adminHome";
			}
			else {
				m.addAttribute("pageInfo", "User Home");
				loggedIn=true;
				page="userHome";
			}
			session.setAttribute("loggedIn", loggedIn);
			session.setAttribute("userName", userName);
		}
		return page;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
