package com.ltizzi.EasyBankBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableWebSecurity
//@EnableJpaRepositories("com.ltizzi.EasyBankBackend.repository")
//@EntityScan("com.ltizzi.EasyBankBackend.model")
public class EasyBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyBankBackendApplication.class, args);
	}

}
