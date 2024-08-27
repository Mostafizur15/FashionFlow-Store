package ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.model.CartItem;
import ecommerce.model.Product;
import ecommerce.service.CartItemService;
import ecommerce.service.ProductService;

@Controller
public class CartController {

	@Autowired
	private CartItemService crtService;
	@Autowired
	private ProductService prdService;
	@RequestMapping("/cart")
	public String showCart(Model m, HttpSession session) {
		m.addAttribute("pageinfo", "Cart");
		String username = (String) session.getAttribute("userName");
		System.out.println("NAME+++++++++++++++++++++++++++++++++"+username);
		List<CartItem> cartList = crtService.getAllCart(username);
		m.addAttribute("cartList", cartList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartList));
		return "cart";
	}
	
	@RequestMapping("/addCart/{productId}")
	public String addCart(@PathVariable("productId") int productId, @RequestParam("quantity") int quantity, HttpSession session, Model m ) {
		Product prd = prdService.getProduct(productId);
		String userName = (String) session.getAttribute("userName");
		
		CartItem crt = new CartItem();
		crt.setProductId(productId);
		crt.setProductName(prd.getProductName());
		crt.setQuantity(quantity);
		crt.setPrice(prd.getPrice());
		crt.setPaymentStatus("NP");
		crt.setUserName(userName);
		crtService.saveCart(crt);
		System.out.println("HELLO----------------");
		List<CartItem> cartList = crtService.getAllCart(userName);
		m.addAttribute("cartList", cartList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartList));
		return "redirect:/cart";
	}
	
	@RequestMapping("/updateCartItem/{cartId}")
	public String updateCart(@PathVariable("cartId") int cartId, @RequestParam("quantity") int quantity, HttpSession session, Model m ) {
		CartItem crt = crtService.getCart(cartId);
		crt.setQuantity(quantity);
		crtService.updateCart(crt);
		
		String userName = (String) session.getAttribute("userName");
		List<CartItem> cartList = crtService.getAllCart(userName);
		m.addAttribute("cartList", cartList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartList));
		return "cart";
	}
	
	
	@RequestMapping("/deleteCartItem/{cartId}")
	public String deleteCart(@PathVariable("cartId") int cartId, HttpSession session, Model m ) {
		CartItem crt = crtService.getCart(cartId);
		crtService.deleteCart(crt);
		
		String userName = (String) session.getAttribute("userName");
		List<CartItem> cartList = crtService.getAllCart(userName);
		m.addAttribute("cartList", cartList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartList));
		return "cart";
	}
	
	public int getGrandTotal(List<CartItem> crtItem) {
		int grandTot=0,count=0;
		while(count<crtItem.size()) {
			grandTot+=(crtItem.get(count).getQuantity()*crtItem.get(count).getPrice());
			count++;
		}
		return grandTot;
	}
	
}
