package dev.airbnbclone.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.airbnbclone.controller.BaseController;
import dev.airbnbclone.entity.Booking;
import dev.airbnbclone.entity.Offer;
import dev.airbnbclone.entity.User;

@Service
public class PublicService extends BaseController{
    

    @Transactional(rollbackFor = Exception.class)
    public User createUser(User user){

        return userDAO.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public User loginUser(String email, String password){

      return userDAO.findByEmail(email);

    }

    @Transactional(rollbackFor = Exception.class)
    public Offer createOffer(Offer offer){

       return offerDAO.save(offer);
    }


    @Transactional(rollbackFor = Exception.class)
    public Booking createBooking(Booking booking){

        return bookingDAO.save(booking);
    }

    @Transactional(rollbackFor = Exception.class)
    public Iterable<Offer> listAllOffer() {

        return offerDAO.findAll();
    }


}
