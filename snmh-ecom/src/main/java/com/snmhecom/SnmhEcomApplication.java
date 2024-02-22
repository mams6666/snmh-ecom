package com.snmhecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories(basePackages="com.snmhecom")
@SpringBootApplication
public class SnmhEcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnmhEcomApplication.class, args);
	}

}
