package it.contrader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import it.contrader.services.UserService;
import it.contrader.services.ClientService;

@SpringBootApplication
public class SpringWebApplication {

	static UserService userService;

	@Autowired
	public SpringWebApplication(UserService userService) {
		this.userService = userService;
	}
	
	static ClientService clientService;

	
	public SpringWebApplication(ClientService clientService) {
		this.clientService = clientService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}
}
