package com.salty.bechef;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication()
@EnableScheduling
public class BechefApplication {

	public static void main(String[] args) {
		SpringApplication.run(BechefApplication.class, args);
	}

}
