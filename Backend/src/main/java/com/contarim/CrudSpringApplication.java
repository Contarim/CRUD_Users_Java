package com.contarim;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.contarim.model.Course;
import com.contarim.repository.CourseRepository;

@SpringBootApplication //indica que a classe é a classe principal do Spring Boot, ou seja, ela irá conter o método main que irá iniciar a aplicação e também irá habilitar as configurações automáticas do Spring Boot
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase (CourseRepository courseRepository) {
		return args -> { 
			courseRepository.deleteAll();

			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory("front-end");
			courseRepository.save(c);
		};
	}
}
