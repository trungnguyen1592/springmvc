package trung.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import trung.model.CategoryDTO;
import trung.service.CategoryService;

@Controller
public class LoginController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/login")
	public String login(Model model) {
		List<CategoryDTO> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/login";
	}
	
}
