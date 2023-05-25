package com.coderhouse.Clase8JPAABM;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class Clase8ApplicationJpaAbmApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(Clase8ApplicationJpaAbmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on. http://localhost:8888/h2-console");

	}
}
