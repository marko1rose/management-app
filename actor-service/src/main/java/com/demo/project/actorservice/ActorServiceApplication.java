package com.demo.project.actorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.demo.project.common.repository")
@EntityScan("com.demo.project.common.model")
public class ActorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActorServiceApplication.class, args);
	}

}
