package me.superoi.springbootdeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // created_at, updated_at 자동 업데이트
@ComponentScan(basePackages = "me.superoi.springbootdeveloper")
public class SpringbootDeveloperApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDeveloperApplication.class, args);
	}
}