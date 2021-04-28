package wjava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping(value = "/welcome")
	public String welcome() {
		return "Welcome to Spring Boot ";
	}

	@GetMapping(value = "/")
	public String defaultPage() {
		return "Welcome to Spring Boot default page";
	}
}