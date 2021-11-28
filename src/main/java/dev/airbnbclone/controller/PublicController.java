package dev.airbnbclone.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.specimpl.ResponseBuilderImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import dev.airbnbclone.entity.Address;
import dev.airbnbclone.entity.Booking;
import dev.airbnbclone.entity.Message;
import dev.airbnbclone.entity.Offer;
import dev.airbnbclone.entity.User;

@RestController
@RequestMapping(value = "/api/v1")
public class PublicController extends BaseController {

    @CrossOrigin
    @RequestMapping(value = "/createUser", method = RequestMethod.POST, produces = "application/json;charset",consumes = "application/json;charset")
    public ResponseEntity<Message> createUser(@RequestBody User user) {

        final User userExist = userDAO.findByEmail(user.getEmail());
        if (userExist != null) {
            throw new WebApplicationException(Response.Status.CONFLICT);
        }
		this.publicService.createUser(user);
		return new ResponseEntity<Message>(
				new Message("Status: 200 - User: " + user.getName() + " created!"),
				HttpStatus.CREATED);
    }

    // @Transactional
    // @CrossOrigin
    // @RequestMapping(value = "loginUser", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    // public User loginUser(@RequestParam("password") final String password, @RequestParam("email") final String email)
    //         throws WebApplicationException {


    //     try {
    //         final User user = userDAO.findByEmail(email);

    //         if (user.getPassword().equals(user.MD5(password))) {
    //             return user;

    //         } else {
    //             throw new WebApplicationException("The Wrong password", Response.Status.NOT_FOUND);
    //         }
    //     } catch (Exception e) {
    //         throw new WebApplicationException(Response.Status.NOT_FOUND);
    //     }

    // }

    @CrossOrigin
    @RequestMapping(value = "/createOffer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> createOffer(@RequestBody Offer offer) {

		this.publicService.createOffer(offer);
		return new ResponseEntity<Message>(
				new Message("Status: 200 - Offer: " + offer.getDescription() + " created!"),
				HttpStatus.CREATED);
    }


    @CrossOrigin
    @RequestMapping(value = "/createBooking", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> createBooking(@RequestBody Booking booking) {

		this.publicService.createBooking(booking);
		return new ResponseEntity<Message>(
				new Message("Status: 200 - Booking: " + booking.getDesired_dates() + " created!"),
				HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value = "/listAllOffer", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Iterable<Offer>> buscarTodos() {

		Iterable<Offer> offer = this.publicService.listAllOffer();

		if (offer == null) {
			return new ResponseEntity<Iterable<Offer>>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Iterable<Offer>>(offer, HttpStatus.OK);
	}

}
