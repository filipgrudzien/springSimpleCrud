package com.mycrud.mycrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.mycrud"})
@EnableJpaRepositories(basePackages="com.mycrud.repositories")
@EntityScan(basePackages="com.mycrud.entities")
public class MycrudApplication {
	public static void main(String[] args) {
		SpringApplication.run(MycrudApplication.class, args);
	}
}
