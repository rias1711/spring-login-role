package com.codegym.repository;

import com.codegym.model.MyUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;

@Qualifier("userRepository")
public interface MyUserRepository extends CrudRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}
