package dev.airbnbclone.data;


import org.springframework.data.repository.CrudRepository;
import org.springframework.web.context.annotation.ApplicationScope;

import dev.airbnbclone.entity.User;

@ApplicationScope
public interface UserDAO extends CrudRepository<User, Long>{

    
}
