package com.apicrud.mackenziepsii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MackenziepsiiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MackenziepsiiApplication.class, args);
	}

	@GetMapping("/")
	public String ApiOn(){
		return "API Online!";
	}

}
