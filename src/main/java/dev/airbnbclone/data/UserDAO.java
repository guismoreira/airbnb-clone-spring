package dev.airbnbclone.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.context.annotation.ApplicationScope;

import dev.airbnbclone.entity.User;

@ApplicationScope
public interface UserDAO extends JpaRepository<User, Long>{
    
    User findByEmail(String email);

    @Override
    void delete(User user);
    
}
