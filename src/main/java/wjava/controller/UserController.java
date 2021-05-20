package wjava.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wjava.beans.User;
import wjava.entity.QuizEntity;
import wjava.entity.ReferenceEntity;
import wjava.entity.UserEntity;
import wjava.service.UserService;

@RequestMapping(value = "/userController")
@RestController
public class UserController {

	@Value("${technologyMap}")
	private String[] technologyMap;

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

	@GetMapping(value = "/getAllTech")
	public List<String> getAllTech() {
		return Arrays.asList(technologyMap);
	}

	@PostMapping(value = "/saveReference")
	public String saveReference(@RequestBody ReferenceEntity entity) throws Exception {
		return userService.saveReference(entity);
	}

	@GetMapping(value = "/getAllReference")
	public List<ReferenceEntity> getAllRefs() {
		return userService.getAllRefs();
	}

	@GetMapping(value = "/getReference/{techName}")
	public List<ReferenceEntity> getReference(@PathVariable("techName") String techName) throws Exception {
		return userService.getReference(techName);
	}

	@DeleteMapping("/deleteReference/{id}")
	public HttpStatus deleteReferenceById(@PathVariable("id") Integer id) throws Exception {
		userService.deleteReferenceById(id);
		return HttpStatus.FORBIDDEN;
	}

	@PostMapping(value = "/saveQuiz")
	public String saveQuiz(@RequestBody QuizEntity entity) throws Exception {
		return userService.saveQuiz(entity);
	}

	@GetMapping(value = "/getAllQuiz")
	public List<QuizEntity> getAllQuizs() {
		return userService.getAllQuizs();
	}

	@DeleteMapping(value = "/deleteQuiz/{id}")
	private String deleteQuiz(@PathVariable("id") int id) throws Exception {
		return userService.deleteQuiz(id);
	}

	@GetMapping(value = "/getQuiz/{techName}")
	public List<QuizEntity> getQuiz(@PathVariable("techName") String techName) {
		return userService.getQuiz(techName);
	}
	
	@GetMapping(value = "/getUser/{userId}")
	public UserEntity getUser(@PathVariable("userId") Integer userId) {
		return userService.getUser(userId);
	}
	
	@PutMapping(value = "/updateUser")
	public String updateUser(@RequestBody UserEntity user) {
		return userService.updateUser(user);
	}
	
	@GetMapping(value = "/getAllUser")
	public List<UserEntity> getAllUser() {
		return userService.getAllUser();
	}

}
