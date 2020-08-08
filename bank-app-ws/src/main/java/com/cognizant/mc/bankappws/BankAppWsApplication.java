package com.cognizant.mc.bankappws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cognizant.mc.bankappws.security.AppProperties;

@SpringBootApplication
public class BankAppWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAppWsApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}
	
	@Bean(name = "AppProperties")
	public AppProperties appProperties() {
		return new AppProperties();
	}
}
