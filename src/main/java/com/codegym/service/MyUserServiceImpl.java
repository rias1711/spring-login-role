package com.codegym.service;

import com.codegym.model.Role;
import com.codegym.model.MyUser;
import com.codegym.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class MyUserServiceImpl implements MyUserService, UserDetailsService {

    @Autowired
    private MyUserRepository myUserRepository;

    @Override
    public List<MyUser> getAllUsers() {
        return (List<MyUser>) myUserRepository.findAll();
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserRepository.findByUsername(username);
        List<Role> roles = new ArrayList<>();
        roles.add(myUser.getRole());

        User user = new User(myUser.getUsername(), myUser.getPassword(), roles);
        return user;
    }
}
