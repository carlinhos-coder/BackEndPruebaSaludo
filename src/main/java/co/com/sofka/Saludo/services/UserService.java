package co.com.sofka.Saludo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.sofka.Saludo.models.UserModel;
import co.com.sofka.Saludo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserModel save(UserModel usermodel) {
		return userRepository.save(usermodel);
	}

	public List<UserModel> listUsers() {
		return userRepository.findAll();
	}

	public UserModel updateUser(UserModel usermodel) {
		return userRepository.save(usermodel);

	}

	public UserModel findById(int id) {
		return userRepository.getById(id);
	}

	public UserModel findNameValidate(String name) {
		return userRepository.findByNombre(name);
	}

	public void deleteUser(UserModel userModel) {
		userRepository.delete(userModel);
	}

}
