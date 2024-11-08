package com.NutriAPI.API_Nutri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.NutriAPI.API_Nutri.model"}) // Pacote onde está o PacienteModel
@EnableJpaRepositories(basePackages = {"com.NutriAPI.API_Nutri.repository"})
public class ApiNutriApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiNutriApplication.class, args);
	}

}
