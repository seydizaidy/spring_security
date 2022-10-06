package com.zaidy.servives;

import com.zaidy.entities.User;
import com.zaidy.entitiesDto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService
{
	User save(UserRegistrationDto registrationDto);
}
