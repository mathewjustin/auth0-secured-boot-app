package com.jwt.secured.repositories;

import com.jwt.secured.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    public User findApplicationUserByUsername(String username);
}
