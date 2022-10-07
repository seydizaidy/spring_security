package com.zaidy.servives;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import com.zaidy.entities.Role;
import com.zaidy.entities.User;
import com.zaidy.entitiesDto.UserRegistrationDto;
import com.zaidy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	@Autowired
	@Lazy
	private BCryptPasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User();
	user.setFirstName(registrationDto.getFirstName());
	user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
	user.setLastName(registrationDto.getLastName());
	user.setEmail(registrationDto.getEmail());
	user.setRoles(Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));

		//return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	//non compris
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

//
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(new User().getRole());
//		return Arrays.asList(authority);
//	}
	
}
