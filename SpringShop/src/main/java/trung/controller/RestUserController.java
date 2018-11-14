package trung.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import trung.model.UserDTO;
import trung.service.UserService;

@RestController
public class RestUserController {
	
	@Autowired
	UserService userService; 
	
	@RequestMapping(value="/listusers", method = RequestMethod.GET)
	public List<UserDTO> listUsers(HttpServletRequest request) {
		List<UserDTO> users = userService.getAllUsers();
		return users;
	}
	
	@RequestMapping(value="/detailuser/{userId}", method = RequestMethod.GET)
	public UserDTO viewUser(
			@PathVariable(name="userId") int userId
			) {
		return userService.getUserById(userId);
	}
	
	@RequestMapping(value="/adduser", method=RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.CREATED)
	public void addUser(@RequestBody UserDTO user) {
		userService.addUser(user);
	}
}
