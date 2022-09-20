package br.com.thymleaf.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

}
