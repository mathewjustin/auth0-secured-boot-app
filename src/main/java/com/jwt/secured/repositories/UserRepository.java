package com.jwt.secured.repositories;

import com.jwt.secured.user.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<ApplicationUser,Long> {

    public ApplicationUser findApplicationUserByUsername(String username);
}
