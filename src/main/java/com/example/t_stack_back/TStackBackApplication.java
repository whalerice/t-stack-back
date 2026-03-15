package com.example.t_stack_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "T-Stack API",
                version = "v1",
                description = "T-Stack 프로젝트 API 문서"
        )
)

@SpringBootApplication
public class TStackBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TStackBackApplication.class, args);
	}

}

