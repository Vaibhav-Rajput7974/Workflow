package com.example.Workflows;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info= @Info ( title = "Grappler Enhancement - Module 1",
				version="1.0.0",
				description="The project is to define the structure of APIs in Role Based Access Controll and Hierarchy",
				termsOfService="https://grappler.innogent.in/dashboard"  ,
				contact = @Contact ( name = "Dishika Jain , Abhishek Patidar, Rishi Raghuvanshi" , email ="dishika.jain@innogent.in ,abhishek.patidar@innogent.in , rishi.raghuvanshi@innogent.in " ) ,
				license = @License ( name = "licence",url="https://github.com/rishiraghuvanshi08/Grappler-Enhancement")

		)
)


public class WorkflowsApplication {
	public static void main(String[] args) {
		SpringApplication.run(WorkflowsApplication.class, args);
		System.out.println("Hello World");
	}
}
