package dev.airbnbclone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.airbnbclone.entity.Address;
import dev.airbnbclone.entity.Offer;

@SpringBootApplication
public class AirbnbCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirbnbCloneApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(	
						) {
		return (args) -> {


			final Offer offer = new Offer(3, true, true, true, 200.0, "november", "bela residencia");
	
		
	     
		};

}}
