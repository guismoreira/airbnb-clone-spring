package dev.airbnbclone.controller;

import org.springframework.beans.factory.annotation.Autowired;

import dev.airbnbclone.data.AddressDAO;
import dev.airbnbclone.data.BookingDAO;
import dev.airbnbclone.data.OfferDAO;
import dev.airbnbclone.data.UserDAO;
import dev.airbnbclone.service.PublicService;

public class BaseController {
    
    @Autowired
    protected UserDAO userDAO;

    @Autowired
    protected BookingDAO bookingDAO;

    @Autowired
    protected AddressDAO addressDAO;

    @Autowired
    protected OfferDAO offerDAO;

    @Autowired
    protected PublicService publicService;


}
