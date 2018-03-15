package ilie.vlad.iulian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class XMLApplication {
	public static void main(String[] args) {
		SpringApplication.run(XMLApplication.class, args);
	}
}

