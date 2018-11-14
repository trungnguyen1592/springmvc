package trung.service;

import java.util.List;

import trung.model.UserDTO;

public interface UserService {
	public void addUser(UserDTO user);

	public void updateUser(UserDTO user);

	public void deleteUser(int id);

	public UserDTO getUserById(int id);

	public List<UserDTO> getAllUsers();
}
