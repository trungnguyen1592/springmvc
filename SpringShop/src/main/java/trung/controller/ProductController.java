package trung.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import trung.model.CategoryDTO;
import trung.model.ProductDTO;
import trung.service.CategoryService;
import trung.service.ProductService;
import trung.validator.ProductValidator;

@Controller
public class ProductController extends MainController{
	
	@Autowired
	ProductService productService; 
	
	@Autowired
	CategoryService categoryService; 
	
	@Autowired
	ProductValidator productValidator;
	
	@RequestMapping("/list-products")
	public String product(Model model) {
		return super.getAllCategory(model, "listProduct");
	}
	
//	@RequestMapping(value="/list-products", method = RequestMethod.GET)
//	public String getAllProduct(HttpServletRequest request) {
//		List<ProductDTO> products = productService.getAllProducts();
//		request.setAttribute("products", products);
//		return "listProduct";
//	}
	
	@RequestMapping(value="/detail-product/{productId}", method = RequestMethod.GET)
	public String viewUser(HttpServletRequest request, @PathVariable(name="productId") int productId ) {
		request.setAttribute("product", productService.getProductById(productId));
		List<CategoryDTO> categories = categoryService.getAllCategories();
		request.setAttribute("categories", categories);
		return "viewProduct";
	}
	
	@RequestMapping(value="/add-product", method = RequestMethod.GET)
	public String addProduct(HttpServletRequest request) {
		List<CategoryDTO> categories = categoryService.getAllCategories();
		request.setAttribute("categories", categories);
		request.setAttribute("product", new ProductDTO());
		return "addProduct";
	}
	
	@Autowired
    ServletContext context;
	
	@RequestMapping(value="/add-product", method=RequestMethod.POST)
	public String addProduct(HttpServletRequest request ,@ModelAttribute("product") ProductDTO productDTO,
			BindingResult bindingResult	) {
		
		MultipartFile file = productDTO.getFile();
		try {
			//File newFile = new File("F:\\" + file.getOriginalFilename());
			
			String relativeWebPath = "/resouces/image/";
			String absoluteFilePath = context.getRealPath(relativeWebPath);
			File newFile = new File(absoluteFilePath+ file.getOriginalFilename());
			
			FileOutputStream fileOutputStream;
			fileOutputStream = new FileOutputStream(newFile);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();
			
			productDTO.setImageUrl(file.getOriginalFilename());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<CategoryDTO> categories = categoryService.getAllCategories();
		request.setAttribute("categories", categories);
		
		productValidator.validate(productDTO, bindingResult);
		if(bindingResult.hasErrors()) {
			return "addProduct";
		}
		productService.addProduct(productDTO);
		return "redirect:/list-products";
	}
	
	@RequestMapping(value="/delete-product/{productId}", method = RequestMethod.GET)
	public String deleteProduct(HttpServletRequest request,@PathVariable(name="productId") int productId) {
		productService.deleteProduct(productId);
		return "redirect:/list-products";
	}
	
	@RequestMapping(value="/edit-product/{productId}", method = RequestMethod.GET)
	public String editProduct(HttpServletRequest request,@PathVariable(name="productId") int productId) {
		List<CategoryDTO> categories = categoryService.getAllCategories();
		request.setAttribute("categories", categories);
		request.setAttribute("product", productService.getProductById(productId));
		return "editProduct";
	}
	
	@RequestMapping(value="/edit-product", method=RequestMethod.POST)
	public String editProduct(HttpServletRequest request, @ModelAttribute("product") ProductDTO productDTO,
			BindingResult bindingResult	) {
		
		MultipartFile file = productDTO.getFile();
		try {
			//File newFile = new File("F:\\" + file.getOriginalFilename());
			
			String relativeWebPath = "/resouces/image/";
			String absoluteFilePath = context.getRealPath(relativeWebPath);
			File newFile = new File(absoluteFilePath+ file.getOriginalFilename());
			
			FileOutputStream fileOutputStream;
			fileOutputStream = new FileOutputStream(newFile);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();
			
			productDTO.setImageUrl(file.getOriginalFilename());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<CategoryDTO> categories = categoryService.getAllCategories();
		request.setAttribute("categories", categories);
		productValidator.validate(productDTO, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "editProduct";
		}
		
		productService.updateProduct(productDTO);
		return "redirect:/list-products";
	}
}
