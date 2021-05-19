package wjava.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		List<String> list = Arrays.asList(technologyMap);
		return list;
	}

	// Reference start
	@PostMapping(value = "/saveReference")
	public String saveReference(@RequestBody ReferenceEntity entity) throws Exception {
		return userService.saveReference(entity);
	}

	@GetMapping(value = "/getAllReference")
	public List<ReferenceEntity> getAllRefs() {
		return userService.getAllRefs();
	}

	@GetMapping(value = "/getReference/{techName}")
	public List<ReferenceEntity> getTechByName(@PathVariable("techName") String techName) throws Exception {

		return userService.getTechByName(techName);
		// return new List<ReferenceEntity>(entity, new HttpHeaders(), HttpStatus.OK);

	}

	@DeleteMapping("/deleteReference/{id}")
	public HttpStatus deleteReferenceById(@PathVariable("id") Integer id) throws Exception {
		userService.deleteReferenceById(id);
		return HttpStatus.FORBIDDEN;
	}
	// ToDo: implement an end point which will get all the refs for a particular
	// techName ex: @Get, /getReference/{techName}

	// ToDo: Implement an end point to delete an reference record for a input ref ID
	// ex: @Delete, /deleteReference/{id}

	// Reference end

	// Question answer start

	@PostMapping(value = "/saveQuiz")
	public String saveQuiz(@RequestBody QuizEntity entity) throws Exception {
		return userService.saveQuiz(entity);
	}

	@GetMapping(value = "/getAllQuiz")
	public List<QuizEntity> getAllQuizs() {
		return userService.getAllQuizs();
	}
	
	
	@GetMapping(value = "/getQuiz/{techName}")
    public List<QuizEntity> getQuiz(@PathVariable("techName") String techName)
    {
        return userService.getQuiz(techName);
    }

	// ToDo: implement an end point which will get all the quizs for a particular
	// techName ex: @Get, /getQuiz/{techName}

	// ToDo: Implement an end point to delete a quiz record for a input quiz ID ex:
	// @Delete, /deleteQuiz/{id}

	// Question answer end

}
