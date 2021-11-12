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

import dev.airbnbclone.entity.User;

@RequestScope
@RestController
@RequestMapping(value = "/api/v1/")
public class ServiceController extends BaseController{

@Transactional
@RequestMapping(
    value = "createUser", 
    produces = MediaType.APPLICATION_JSON_VALUE,
    method = RequestMethod.POST)
    public User createUser(@RequestParam("name") final String name,
                            @RequestParam("password") final String password,
                            @RequestParam("email") final String email) 
    throws WebApplicationException{

        final User user = new User();
        final User userExist = userDAO.findByEmail(email);

        if(name.isEmpty() || userExist != null) {
            ResponseBuilderImpl builder = new ResponseBuilderImpl();
            builder.status(Response.Status.BAD_REQUEST);
            builder.entity("name cannot be empty");
            Response response = builder.build();
            throw new WebApplicationException(response);

        }else{
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            userDAO.save(user);
        }
        return user;
    }

}
