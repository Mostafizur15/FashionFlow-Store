package ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.service.CartItemService;
import ecommerce.service.CategoryService;
import ecommerce.service.OrderService;
import ecommerce.service.ProductService;
import ecommerce.service.UserService;
import ecommerce.model.CartItem;
import ecommerce.model.OrderDetail;
import ecommerce.model.UserDetails;

@Controller
public class PaymentController {

	@Autowired
	CartItemService cartService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	OrderService orderService;
	@Autowired
	UserService userService;
	
	@RequestMapping("/checkout")
	public String checkOut(Model m,HttpSession session) {
		String userName=(String) session.getAttribute("userName");
		List<CartItem> cartList=cartService.getAllCart(userName);
		m.addAttribute("cartList", cartList);
		int grandTotal = this.getGrandTotal(cartList);
		m.addAttribute("grandTotal", grandTotal);
		UserDetails userDetail = userService.getUser(userName);
		String address=userDetail.getCustomerAddr();
		m.addAttribute("addr", address);
		return "OrderConfirm";
	}
	
	@RequestMapping(value="/updateaddr", method=RequestMethod.POST)
	public String updateAddress(@RequestParam("addr") String address,Model m,HttpSession session) {
		String userName=(String) session.getAttribute("userName");
		List<CartItem> cartList=cartService.getAllCart(userName);
		m.addAttribute("cartList", cartList);
		int grandTotal = this.getGrandTotal(cartList);
		m.addAttribute("grandTotal", grandTotal);
		
		UserDetails userDetail = userService.getUser(userName);
		userDetail.setCustomerAddr(address);
		userService.updateUser(userDetail);
		m.addAttribute("addr", address);
		return "OrderConfirm";
	}
	
	@RequestMapping("/payment")
	public String payment(Model m,HttpSession session) {
		return "payment";
	}
	@RequestMapping(value="/receipt",method=RequestMethod.POST)
	public String generateReceipt(@RequestParam("rd") String rd, Model m,HttpSession session) {
		String userName=(String) session.getAttribute("userName");
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setShippingAddr(userService.getUser(userName).getCustomerAddr());
		orderDetail.setTrans("rd");
		orderDetail.setUserName(userName);
		
		List<CartItem> cartList=cartService.getAllCart(userName);
		m.addAttribute("cartList", cartList);
		int grandTotal = this.getGrandTotal(cartList);
		m.addAttribute("grandTotal", grandTotal);
		
		orderDetail.setTotalAmount(grandTotal);
		orderService.saveOrder(orderDetail);
		orderService.updateCart(userName);
		m.addAttribute("orderDetail", orderDetail);
		m.addAttribute("addr", orderDetail.getShippingAddr());
		return "receipt";
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
