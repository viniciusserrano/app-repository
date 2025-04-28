package com.br.imobiliaria.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {
		"com.br.imobiliaria.api.imovel",
		"com.br.imobiliaria.api.mongoconfig"
})
@EnableFeignClients
public class ApiImobiliariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiImobiliariaApplication.class, args);
	}

}
