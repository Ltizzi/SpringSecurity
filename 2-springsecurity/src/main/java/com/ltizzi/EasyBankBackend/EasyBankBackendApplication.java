package com.ltizzi.EasyBankBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
//Method level security
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
//@EnableWebSecurity(debug = true)
//@EnableJpaRepositories("com.ltizzi.EasyBankBackend.repository")
//@EntityScan("com.ltizzi.EasyBankBackend.model")
public class EasyBankBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(EasyBankBackendApplication.class, args);
	}

}
