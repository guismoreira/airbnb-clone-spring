package dev.airbnbclone.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.context.annotation.ApplicationScope;

import dev.airbnbclone.entity.*;

@ApplicationScope
public interface AddressDAO extends JpaRepository<Address, Long>{
    
    @Override
    void delete(Address address);
}
