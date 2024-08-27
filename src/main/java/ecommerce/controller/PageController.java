package ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.model.UserDetails;
import ecommerce.service.UserService;

@Controller
public class PageController {
	@Autowired
	UserService userDetailService;
	@RequestMapping(value = "/to", method = RequestMethod.GET)
    public String handleToRequest() {
        // Return the name of the JSP page that will be rendered
		System.out.println("TO");
        return "home"; // Make sure you have a myPage.jsp in your views directory
    }
	@RequestMapping("/")
	public String welcomePage(Model m) {
		return "home";
	}
	@RequestMapping("/home")
	public String home(Model m) {
		m.addAttribute("pageinfo", "Home");
		System.out.println("HELLO HOME");
		return "home";
	}
	@RequestMapping("/login")
	public String login(Model m) {
		m.addAttribute("pageinfo", "Login");
		System.out.println("HELLO LOGIN");
		return "login";
	}
	@RequestMapping("/contact")
	public String contact(Model m) {
		m.addAttribute("pageinfo", "Contact US");
		System.out.println("HELLO CONTACT");
		return "contact";
	}
	@RequestMapping("/about")
	public String about(Model m) {
		m.addAttribute("pageinfo", "About US");
		System.out.println("HELLO ABOUT US");
		return "about";
	}
	@RequestMapping("/register")
	public String register(Model m) {
		m.addAttribute("pageinfo", "Register");
		System.out.println("HELLO Registration");
		return "register";
	}
	@RequestMapping(value="/performRegistration", method=RequestMethod.POST)
	public String performRegister(Model m,@RequestParam("customerName") String customerName, @RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("address") String address) {
		m.addAttribute("pageinfo", "Register");
		UserDetails user= new UserDetails();
		user.setCustomerName(customerName);
		user.setUserName(userName);
		user.setPassword(password);
		user.setCustomerAddr(address);
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		userDetailService.registerUser(user);
		System.out.println("HELLO Registration1");
		System.out.println(address);
		return "login";
	}
	
	
	
	
	
	
	
	
	
	
	
}
