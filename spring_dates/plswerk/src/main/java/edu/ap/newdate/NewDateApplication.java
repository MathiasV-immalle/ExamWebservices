package edu.ap.newdate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class NewDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewDateApplication.class, args);
	}

}
