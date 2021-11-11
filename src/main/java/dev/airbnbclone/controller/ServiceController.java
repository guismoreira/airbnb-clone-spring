package dev.airbnbclone.controller;

import javax.transaction.Transactional;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public User createUser(@RequestParam("name") final String name){
        final User user = new User();
        user.setName(name);
        userDAO.save(user);
        return user;
    }

}
