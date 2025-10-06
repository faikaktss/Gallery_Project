package com.faik.Starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.faik"})
@EntityScan(basePackages = {"com.faik"})
@EnableJpaRepositories(basePackages = {"com.faik"})
public class GalleristAppllicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(GalleristAppllicationStarter.class, args);
	}

}
