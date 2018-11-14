package trung.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import trung.model.UserDTO;
import trung.validator.UserValidator;

@Controller
class HelloController {
	
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping("/welcome")
	public String sayHello(ModelMap model) {
		model.addAttribute("msg", "Xin chào Spring 4 MVC");
		return "welcome";
	}
	
	//@RequestMapping(value="/add-user", method=RequestMethod.GET) 
	public String addUser(HttpServletRequest request) {
		UserDTO user = new UserDTO();
		request.setAttribute("user", user);
		return "addUser";
	}
	
	//@RequestMapping(value="/add-user", method=RequestMethod.POST)
	public String addUser(HttpServletRequest request, @ModelAttribute("user") UserDTO user,
			BindingResult bindingResult
			) {
		userValidator.validate(user, bindingResult);
		if(bindingResult.hasErrors()) {
			return "addUser";
		}
		request.setAttribute("user", user);
		return "viewUser";
	}
}