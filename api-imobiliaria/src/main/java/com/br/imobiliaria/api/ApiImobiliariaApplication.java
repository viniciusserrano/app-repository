package com.br.imobiliaria.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiImobiliariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiImobiliariaApplication.class, args);
	}

}
