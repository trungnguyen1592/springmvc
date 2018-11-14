package trung.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import trung.model.UserDTO;
import trung.service.UserService;
import trung.validator.UserValidator;

@Controller
@RequestMapping("/admin")
public class UserController {
	
	@Autowired
	UserService userService; 
	
	@Autowired
	UserValidator userValidator;
	
	@RequestMapping(value="/list-users", method = RequestMethod.GET)
	public String getAllUser(HttpServletRequest request) {
		List<UserDTO> users = userService.getAllUsers();
		request.setAttribute("users", users);
		return "listUser";
	}
	
	@RequestMapping(value="/detail-user/{userId}", method = RequestMethod.GET)
	public String viewUser(HttpServletRequest request,
			@PathVariable(name="userId") int userId
			) {
		request.setAttribute("user", userService.getUserById(userId));
		return "viewUser";
	}
	
	@RequestMapping(value="/add-user", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request) {
		request.setAttribute("user", new UserDTO());
		return "addUser";
	}
	
	@RequestMapping(value="/add-user", method=RequestMethod.POST)
	public String addUser(HttpServletRequest request, @ModelAttribute("user") UserDTO user,
			BindingResult bindingResult	) {
		userValidator.validate(user, bindingResult);
		if(bindingResult.hasErrors()) {
			return "addUser";
		}
		userService.addUser(user);
		return "redirect:/admin/list-users";
	}
	
	@RequestMapping(value="/delete-user/{userId}", method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest request,@PathVariable(name="userId") int userId) {
		userService.deleteUser(userId);
		return "redirect:/admin/list-users";
	}
	
	@RequestMapping(value="/edit-user/{userId}", method = RequestMethod.GET)
	public String editUser(HttpServletRequest request,@PathVariable(name="userId") int userId) {
		request.setAttribute("user", userService.getUserById(userId));
		return "editUser";
	}
	
	@RequestMapping(value="/edit-user", method=RequestMethod.POST)
	public String editUser(HttpServletRequest request, @ModelAttribute("user") UserDTO user,
			BindingResult bindingResult
			) {
		userValidator.validate(user, bindingResult);
		if(bindingResult.hasErrors()) {
			return "editUser";
		}
		userService.updateUser(user);
		return "redirect:/admin/list-users";
	}
}
