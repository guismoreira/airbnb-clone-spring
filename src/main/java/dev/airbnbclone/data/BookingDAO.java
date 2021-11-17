package dev.airbnbclone.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.context.annotation.ApplicationScope;

import dev.airbnbclone.entity.*;

@ApplicationScope
public interface BookingDAO extends JpaRepository<Booking, Long>{

    @Override
    void delete(Booking booking);
    
}
