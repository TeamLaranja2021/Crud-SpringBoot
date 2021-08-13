package br.com.laranja.springcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCrudApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}

}
