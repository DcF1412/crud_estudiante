package com.dairon.crud_estudiante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class CrudEstudianteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudEstudianteApplication.class, args);
	}

}
