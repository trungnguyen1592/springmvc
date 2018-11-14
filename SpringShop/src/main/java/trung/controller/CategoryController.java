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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import trung.model.CategoryDTO;
import trung.service.CategoryService;
import trung.service.ProductService;
import trung.validator.CategoryValidator;

@Controller
public class CategoryController extends MainController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@Autowired
	CategoryValidator categoryValidator;

	@Autowired
	ServletContext context;

	@RequestMapping("/")
	public String viewMenu(Model model) {
		model.addAttribute("homepage", "homepage");
		return super.getAllCategory(model, "home");
	}

	@GetMapping(value = "/detail-category/{categoryId}")
	public String viewCategory(Model model, @PathVariable(name = "categoryId") int categoryId) {
		return super.getProductByCategory(model, categoryId, "viewCategory");
	}

	@GetMapping(value = "/admin/detail-category/{categoryId}")
	public String viewAdminCategory(Model model, @PathVariable(name = "categoryId") int categoryId) {
		return super.getProductByCategory(model, categoryId, "viewCategory");
	}

	@RequestMapping(value = "/list-categories", method = RequestMethod.GET)
	public String getAllCategory(HttpServletRequest request) {
		List<CategoryDTO> categories = categoryService.getAllCategories();
		request.setAttribute("categories", categories);
		return "listCategory";
	}

	// @RequestMapping(value = "/detail-category/{categoryId}", method =
	// RequestMethod.GET)
	// public String viewCategory(HttpServletRequest request, @PathVariable(name =
	// "categoryId") int categoryId) {
	// request.setAttribute("products",
	// productService.getAllProductsById(categoryId));
	// request.setAttribute("category",
	// categoryService.getCategoryById(categoryId));
	// return "viewCategory";
	// }

	@RequestMapping(value = "/add-category", method = RequestMethod.GET)
	public String addCategory(HttpServletRequest request) {
		request.setAttribute("category", new CategoryDTO());
		return "addCategory";
	}

	@RequestMapping(value = "/add-category", method = RequestMethod.POST)
	public String addCategory(HttpServletRequest request, @ModelAttribute("category") CategoryDTO category,
			BindingResult bindingResult) {

		MultipartFile file = category.getFile();
		try {
			// File newFile = new File("F:\\" + file.getOriginalFilename());

			String relativeWebPath = "/resouces/image/";
			String absoluteFilePath = context.getRealPath(relativeWebPath);
			File newFile = new File(absoluteFilePath + file.getOriginalFilename());

			FileOutputStream fileOutputStream;
			fileOutputStream = new FileOutputStream(newFile);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();

			category.setThumbnail(file.getOriginalFilename());
			;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		categoryValidator.validate(category, bindingResult);
		if (bindingResult.hasErrors()) {
			return "addCategory";
		}
		categoryService.addCategory(category);
		return "redirect:/list-categories";
	}

	//
	// @RequestMapping(value = "/delete-category/{categoryId}", method =
	// RequestMethod.GET)
	// public String deleteCategory(HttpServletRequest request, @PathVariable(name =
	// "categoryId") int categoryId) {
	// categoryService.deleteCategory(categoryId);
	// return "redirect:/admin/list-categories";
	// }
	//
	@RequestMapping(value = "/edit-category/{categoryId}", method = RequestMethod.GET)
	public String editCategory(HttpServletRequest request, @PathVariable(name = "categoryId") int categoryId) {
		request.setAttribute("category", categoryService.getCategoryById(categoryId));
		return "editCategory";
	}

	@RequestMapping(value = "/edit-category", method = RequestMethod.POST)
	public String editCategory(HttpServletRequest request, @ModelAttribute("category") CategoryDTO category,
			BindingResult bindingResult) {
		MultipartFile file = category.getFile();
		try {
			// File newFile = new File("F:\\" + file.getOriginalFilename());

			String relativeWebPath = "/resouces/image/";
			String absoluteFilePath = context.getRealPath(relativeWebPath);
			File newFile = new File(absoluteFilePath + file.getOriginalFilename());

			FileOutputStream fileOutputStream;
			fileOutputStream = new FileOutputStream(newFile);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();

			category.setThumbnail(file.getOriginalFilename());
			;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		categoryValidator.validate(category, bindingResult);
		if (bindingResult.hasErrors()) {
			return "editCategory";
		}
		categoryService.updateCategory(category);
		return "redirect:/list-categories";
	}
}
