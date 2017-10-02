package com.example.springbatchannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class SpringBatchAnnotationExampleApplication {

	public static void main(String[] args) {
		System.setProperty("input", "file:"+ new File("C:/Users/mscuffham/git/SpringExamples/resources/in.csv").getAbsolutePath());
		System.setProperty("output", "file:"+ new File("C:/Users/mscuffham/git/SpringExamples/resources/out.csv").getAbsolutePath());
		SpringApplication.run(SpringBatchAnnotationExampleApplication.class, args);
	}
}
