package com.middlend.middlend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * @@author Oluwanishola Oretan
 * @// TODO: 02/04/2021  include={SecurityAutoConfiguration.class})
 */

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class MiddlendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiddlendApplication.class, args);
	}

}
