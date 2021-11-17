package dev.airbnbclone.controller;

import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.specimpl.ResponseBuilderImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import dev.airbnbclone.entity.Address;
import dev.airbnbclone.entity.Offer;
import dev.airbnbclone.entity.User;

@RequestScope
@RestController
@RequestMapping(value = "/api/v1/")
public class ServiceController extends BaseController {

    @Transactional
    @RequestMapping(value = "createUser", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public User createUser(@RequestParam("name") final String name, @RequestParam("password") final String password,
            @RequestParam("email") final String email) throws WebApplicationException {

        final User user = new User();
        final User userExist = userDAO.findByEmail(email);

        if (name.isEmpty() || userExist != null) {
            ResponseBuilderImpl builder = new ResponseBuilderImpl();
            builder.status(Response.Status.BAD_REQUEST);
            builder.entity("name cannot be empty");
            Response response = builder.build();
            throw new WebApplicationException(response);

        } else {
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            userDAO.save(user);
        }
        return user;
    }

    @Transactional
    @RequestMapping(value = "loginUser", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public String loginUser(@RequestParam("password") final String password, @RequestParam("email") final String email)
            throws WebApplicationException {

        String message = null;

        try {
            final User user = userDAO.findByEmail(email);

            if (user.getPassword().equals(user.MD5(password))) {
                message = "Login Successful";
                return message = "login sucessful";

            } else {
                message = "The user provides a wrong e-mail or password";
                throw new WebApplicationException("The Wrong password", Response.Status.NOT_FOUND);
            }
        } catch (Exception e) {
            message = "The login method generates a DAO Exception";
            throw new WebApplicationException(message, Response.Status.NOT_FOUND);
        }

    }

    @Transactional
    @RequestMapping(value = "createOffer", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Offer createOffer(@RequestParam("numberOfBeds") final int numberOfBeds,
            @RequestParam("isWifi") final boolean isWifi, @RequestParam("isKitchen") final boolean isKitchen,
            @RequestParam("isTV") final boolean isTV, @RequestParam("available_dates") final String available_dates,
            @RequestParam("city") final String city, @RequestParam("street") final String street,
            @RequestParam("description") final String description, @RequestParam("uf") final String uf,
            @RequestParam("price") final Long price) throws WebApplicationException {

        final Offer offer = new Offer();
        final Address address = new Address();

        if (available_dates.isEmpty() || description.isEmpty() || price == null) {
            ResponseBuilderImpl builder = new ResponseBuilderImpl();
            builder.status(Response.Status.BAD_REQUEST);
            builder.entity("name cannot be empty");
            Response response = builder.build();
            throw new WebApplicationException(response);

        } else {
            offer.setNumberOfBeds(numberOfBeds);
            offer.setIsKitchen(isKitchen);
            offer.setAvailable_dates(available_dates);
            offer.setDescription(description);
            offer.setPrice(price);
            offer.setIsTV(isTV);
            offer.setIsWifi(isWifi);

            address.setCity(city);
            address.setStreet(street);
            address.setUf(uf);

            offerDAO.save(offer);
        }
        return offer;
    }

}
