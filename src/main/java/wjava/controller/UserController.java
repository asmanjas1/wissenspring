package wjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	// Reference start
	@PostMapping(value = "/saveReference")
	public String saveReference(@RequestBody ReferenceEntity entity) throws Exception {
		return userService.saveReference(entity);
	}
	
	@GetMapping(value = "/getAllReference")
	public List<ReferenceEntity> getAllRefs(){
		return userService.getAllRefs();
	}
	
	//ToDo: implement an end point which will get all the refs for a particular techName ex: @Get, /getReference/{techName}
	
	//ToDo: Implement an end point to delete an reference record for a input ref ID ex: @Delete, /deleteReference/{id}
	
	//Reference end
	
	// Question answer start
	
	@PostMapping(value = "/saveQuiz")
	public String saveQuiz(@RequestBody QuizEntity entity) throws Exception {
		return userService.saveQuiz(entity);
	}
	
	@GetMapping(value = "/getAllQuiz")
	public List<QuizEntity> getAllQuizs(){
		return userService.getAllQuizs();
	}
	
	//ToDo: implement an end point which will get all the quizs for a particular techName ex: @Get, /getQuiz/{techName}
	
	//ToDo: Implement an end point to delete a quiz record for a input quiz ID ex: @Delete, /deleteQuiz/{id}
	
	// Question answer end

}
