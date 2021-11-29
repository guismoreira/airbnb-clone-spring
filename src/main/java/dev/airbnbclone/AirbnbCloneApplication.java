package dev.airbnbclone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.airbnbclone.controller.BaseController;
import dev.airbnbclone.entity.Address;
import dev.airbnbclone.entity.Offer;
import dev.airbnbclone.entity.User;

@SpringBootApplication
public class AirbnbCloneApplication extends BaseController{

	public static void main(String[] args) {
		SpringApplication.run(AirbnbCloneApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(	
						) {
		return (args) -> {
			final User user = new User("jose", "asdasd", "519191", "035", "jose@email.com");
			userDAO.save(user);

			final Offer offer = new Offer(3, true, true, true, 200.0, "november", "bela residencia");
			offerDAO.save(offer);


			final Offer offer2 = new Offer(3, true, true, true, 200.0, "setember", "belo apartamento");
			offerDAO.save(offer2);
		};

}}
