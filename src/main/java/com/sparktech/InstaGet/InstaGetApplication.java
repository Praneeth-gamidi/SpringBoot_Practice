package com.sparktech.InstaGet;

import com.sparktech.InstaGet.services.ResponseGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class InstaGetApplication {
	public static void main(String[] args) {
		 ApplicationContext context = SpringApplication.run(InstaGetApplication.class, args);
		 ResponseGenerator rg = context.getBean(ResponseGenerator.class);
		rg.work();
	}
}
