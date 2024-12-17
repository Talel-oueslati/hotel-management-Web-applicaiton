package com.exemple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) 

public class ReservationGestionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationGestionsApplication.class, args);
		System.out.print("haw hné");
	}

}
