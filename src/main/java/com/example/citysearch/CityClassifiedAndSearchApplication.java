 
package com.example.citysearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("com.virtusa.bean")
@ComponentScan(basePackages = {"com.virtusa.config","com.virtusa.controller"})
public class CityClassifiedAndSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityClassifiedAndSearchApplication.class, args);
	}

}
