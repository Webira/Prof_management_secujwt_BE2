package com.web.usersmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class UsersManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersManagementApplication.class, args);
	}

	/*@GetMapping("/")
	public String apiRoot() {
		return "hello";
	}*/

}
