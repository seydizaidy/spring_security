package com.zaidy.springsecth2.services;

;
import com.zaidy.springsecth2.model.User;
import com.zaidy.springsecth2.repositories.RoleRepository;
import com.zaidy.springsecth2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;


public interface UserService extends UserDetailsService
{
    User saveUser(User user);

    User findUserByEmail(String email);


}

