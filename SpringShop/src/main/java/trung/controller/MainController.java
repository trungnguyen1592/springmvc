package trung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import trung.model.CategoryDTO;
import trung.model.ProductDTO;
import trung.service.CategoryService;
import trung.service.ProductService;

public class MainController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;
	
	public String getAllCategory(Model model, String viewName) {
		List<CategoryDTO> categories = categoryService.getAllCategories();
		List<ProductDTO> products = productService.getAllProducts();
		model.addAttribute("categories", categories);
		model.addAttribute("products", products);
		return viewName;
	}
	
	public String getProductByCategory(Model model, int category_id,String viewName) {
		List<CategoryDTO> categories = categoryService.getAllCategories();
		List<ProductDTO> products = productService.getAllProductsById(category_id);
		CategoryDTO category = categoryService.getCategoryById(category_id);
		model.addAttribute("category", category);
		model.addAttribute("categories", categories);
		model.addAttribute("products", products);
		return viewName;
	}
	
	
	
}
