package ecommerce.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import ecommerce.model.Product;
import ecommerce.service.CategoryService;
import ecommerce.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService ecomProductService;

    @Autowired
    private CategoryService ecomcategoryService;

    @RequestMapping("/product")
    public String showProduct(Model m) {
        m.addAttribute("product", new Product());
        m.addAttribute("pageinfo", "Product");
        m.addAttribute("listOfProduct", this.ecomProductService.getAllProduct());
        m.addAttribute("categoryList", this.ecomcategoryService.getAllCategory());
        return "product";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addOrUpdateProduct(@ModelAttribute("product") Product product,
                                     @RequestParam("pImage") CommonsMultipartFile file,
                                     Model m, HttpSession s, RedirectAttributes redirectAttributes,HttpServletRequest req) {
        System.out.println("Processing product...");
        boolean isUpdate = product.getProductId() != 0;
        this.ecomProductService.saveProduct(product);
        // Define the path for image upload
        System.out.println(req.getContextPath());
        String path = "C:\\Users\\FORHAD\\eclipse-workspace\\ECommerce\\src\\main\\webapp\\resources\\images\\";
        path = path + product.getProductId() + ".jpg";
        System.out.println("Image path: " + path);
        
        if (!file.isEmpty()) {
            try {
                byte[] data = file.getBytes();
                FileOutputStream fos = new FileOutputStream(path);
                BufferedOutputStream bs = new BufferedOutputStream(fos);
                bs.write(data);
                bs.close();
                fos.close();
                m.addAttribute("filename", file.getOriginalFilename());
                System.out.println("Image uploaded successfully.");
            } catch (Exception e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("errorMessage", "Image upload failed.");
                return "redirect:/product"; // Redirect to avoid duplicate submission
            }
        } else {
            System.out.println("No image file uploaded.");
            redirectAttributes.addFlashAttribute("errorMessage", "Image upload failed.");
            return "redirect:/product";
        }

        // Set the success message
        if (isUpdate) {
            redirectAttributes.addFlashAttribute("message", "Data Updated Successfully.");
        } else {
            redirectAttributes.addFlashAttribute("message", "Data Added Successfully.");
        }
        return "redirect:/product";
    }


    @RequestMapping("/deleteProduct/{productId}")
    public RedirectView deleteProduct(HttpServletRequest req, @PathVariable int productId, RedirectAttributes m) {
        
    	Product prod = this.ecomProductService.getProduct(productId);
        boolean chk = this.ecomProductService.deleteProduct(prod);
        RedirectView rdView = new RedirectView();
        if (chk)
            m.addFlashAttribute("message", "Product successfully deleted.");
        else
        	m.addFlashAttribute("errorMessage", "Something wrong.");
        rdView.setUrl(req.getContextPath() + "/product");
        return rdView;
    }

    @RequestMapping("/updateProduct/{productId}")
    public String updateProduct(HttpServletRequest req, @PathVariable int productId, Model m) {
    	Product prd = this.ecomProductService.getProduct(productId);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(prd.getProductName());
        m.addAttribute("fetchProduct", prd);
        m.addAttribute("pageinfo", "Update Product");
        m.addAttribute("categoryList", this.ecomcategoryService.getAllCategory());
        return "updateProduct";
    }
    @RequestMapping("/productDisplay")
    public String displayAllProduct(Model m) {
        m.addAttribute("pageinfo", "Product Catalog");
        m.addAttribute("listOfProduct", this.ecomProductService.getAllProduct());
        return "productDisplay";
    }
    @RequestMapping("/totalProductDisplay/{productId}")
    public String totalProductDisplay(HttpServletRequest req, @PathVariable int productId, Model m) {
    	m.addAttribute("pageinfo", "Product Info");
    	Product prd = this.ecomProductService.getProduct(productId);
        System.out.println(prd.getProductDesc());
        m.addAttribute("product", prd);
        return "totalProductDisplay";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
