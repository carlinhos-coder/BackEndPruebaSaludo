package co.com.sofka.Saludo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofka.Saludo.models.UserModel;
import co.com.sofka.Saludo.services.UserService;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) {
		return new ResponseEntity<UserModel>(userService.save(user), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<UserModel>> FindAll() {
		return ResponseEntity.ok(this.userService.listUsers());
	}

	@PostMapping(path = "/update")
	public ResponseEntity<UserModel> updateUser(@RequestBody UserModel userModel) {
		if (userModel == null) {
			return new ResponseEntity<UserModel>(HttpStatus.NOT_ACCEPTABLE);
		}

		UserModel user = this.userService.findById(userModel.getId());
		if (user == null) {
			return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
		} else {
			System.out.println("");
			return new ResponseEntity<UserModel>(userService.save(userModel), HttpStatus.CREATED);
		}
	}

	@GetMapping(path = "/validateName")
	public ResponseEntity<Boolean> validate(@RequestParam(value = "name") String name) {
		return new ResponseEntity<Boolean>(userService.findNameValidate(name), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> removeUser(@Param("id") int id) {
		UserModel userModel = this.userService.findById(id);
		if (userModel != null) {
			this.userService.deleteUser(userModel);
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("User no found", HttpStatus.NOT_FOUND);
		}
	}

}
