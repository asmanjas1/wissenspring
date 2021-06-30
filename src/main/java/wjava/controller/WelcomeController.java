package wjava.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
	
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://34.93.78.219:3306/ashu";
		String username = "root";
		String password = "8699936575";

		System.out.println("Connecting database...");
		try  {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			while (rs.next()) {
			    System.out.println(rs.getString(1));
			}
		    System.out.println("Database connected!");
		} catch (Exception e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}

	}
}