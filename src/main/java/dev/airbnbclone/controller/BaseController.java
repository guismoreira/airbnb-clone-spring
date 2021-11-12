package dev.airbnbclone.controller;

import org.springframework.beans.factory.annotation.Autowired;

import dev.airbnbclone.data.UserDAO;

public class BaseController {
    
    @Autowired
    protected UserDAO userDAO;


}
