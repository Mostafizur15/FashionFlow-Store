package ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import ecommerce.model.Category;
import ecommerce.model.Product;
import ecommerce.service.CategoryService;
import ecommerce.service.ProductService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService ecomService;
	@Autowired 
	private ProductService prodService;
	@RequestMapping("/category")
	public String showCategory(Model m) {
		m.addAttribute("pageinfo", "Category");
		m.addAttribute("listOfCategory", this.ecomService.getAllCategory());
		return "category";
	}
	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public RedirectView addCategory(@ModelAttribute Category cat, HttpServletRequest req,RedirectAttributes  m) {
		m.addFlashAttribute("message", "Something wrong.");
		boolean isUpdate=cat.getCategoryId() != 0;
		boolean chk=this.ecomService.saveCategory(cat);
		System.out.println(chk);
		System.out.println("Category Added");
		RedirectView rdView= new RedirectView();
		rdView.setUrl(req.getContextPath()+"/category");
		if(!isUpdate)
			m.addFlashAttribute("message", "Category successfully added.");
		else m.addFlashAttribute("message", "Category successfully updated.");
		return rdView;
	}
	@RequestMapping("/deleteCategory/{categoryId}")
	public RedirectView delete(HttpServletRequest req,@PathVariable int categoryId, RedirectAttributes m) {
		Category cat = this.ecomService.getCategory(categoryId);
		//System.out.println(cat.getCategoryName()+" "+cat.getCategoryId()+" "+cat.getCategoryDesc()); if it open then we will get Lazyiniexception. as there is no transection annotaion. 
		boolean chk=this.ecomService.deleteCategory(cat);
		RedirectView rdView = new RedirectView();
		if(chk)
			m.addFlashAttribute("message", "Category successfully deleted.");
		rdView.setUrl(req.getContextPath()+"/category");
		return rdView;
	}
	@RequestMapping("/updateCategory/{categoryId}")
	public ModelAndView update(HttpServletRequest req,@PathVariable int categoryId,ModelAndView m) {
		System.out.println("Hollllaaa-----------------");
		Category cat = this.ecomService.getCategory(categoryId);
		m.addObject("category", cat);
		m.setViewName("updateCategory");
		return m;
	}
	@RequestMapping("/mens")
	public String mensCategory(Model m) {
		m.addAttribute("pageinfo", "Men's Category");
		int categoryId=ecomService.getCategoryId("Men's");
		List<Product> products=prodService.getAllProductByCategoryId(categoryId);
		m.addAttribute("listOfProduct", products);
		return "productDisplay";
	}
	@RequestMapping("/womens")
	public String womensCategory(Model m) {
		m.addAttribute("pageinfo", "Women's Category");
		int categoryId=ecomService.getCategoryId("Women's");
		List<Product> products=prodService.getAllProductByCategoryId(categoryId);
		m.addAttribute("listOfProduct", products);
		return "productDisplay";
	}
	@RequestMapping("/kids")
	public String kidsCategory(Model m) {
		m.addAttribute("pageinfo", "Kid's Category");
		int categoryId=ecomService.getCategoryId("Kid's");
		List<Product> products=prodService.getAllProductByCategoryId(categoryId);
		m.addAttribute("listOfProduct", products);
		return "productDisplay";
	}
	
	
	
}
