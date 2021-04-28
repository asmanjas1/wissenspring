package wjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wjava.beans.User;
import wjava.entity.UserEntity;
import wjava.service.UserService;


@RequestMapping(value = "/userController")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/signUp")
	public UserEntity doSignUp(@RequestBody User user) throws Exception {
		return userService.signUp(user);
	}

	@PostMapping(value = "/login")
	public User doLogin(@RequestBody User user) throws Exception {
		return userService.doLogin(user);
	}

}
