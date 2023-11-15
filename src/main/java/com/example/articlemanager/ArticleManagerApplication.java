package com.example.articlemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.articlemanager")
public class ArticleManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleManagerApplication.class, args);
	}

}
