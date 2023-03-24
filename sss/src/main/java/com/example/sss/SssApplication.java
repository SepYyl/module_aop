package com.example.sss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cn.ac.iie.cloud.iie.logs.aop", "com.example.sss"})
public class SssApplication {
	public static void main(String[] args) {
		SpringApplication.run(SssApplication.class, args);
	}

}
