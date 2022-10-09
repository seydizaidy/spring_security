package com.zaidy.crudsecrest.services.Impl;

import com.zaidy.crudsecrest.model.UserInfo;
import com.zaidy.crudsecrest.repositories.UserInfoRepository;
import com.zaidy.crudsecrest.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserInfoServiceImp implements UserInfoService
{
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    @Lazy
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserInfo createUser(UserInfo userInfo)
    {
        UserInfo user = new UserInfo();
        user.setUsername(userInfo.getUsername());
        user.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        user.setCountry(userInfo.getCountry());
        user.setFullName(userInfo.getFullName());
        user.setEnabled(userInfo.getEnabled());
        user.setRole(userInfo.getRole());
        return userInfoRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
      //  return new UserDetailsImp(userInfo); bon mais je prefrere ne pas utiliser UserDetailsImpl par contre
        //je veux utiliser une de ses methodes pour factoriser le code
       //Inconvient la methode getAutorities n est pas appeles , il nousfaudra l appeler dans la configuratio
        //pour avoir les authorites
        UserInfo userInfo=userInfoRepository.findByUsername(username);
        if (userInfo == null) throw new UsernameNotFoundException("username:  "+username+"  is not found");
        GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());

   return new org.springframework.security.core.userdetails.User(userInfo.getUsername(),
           userInfo.getPassword(), Arrays.asList(authority));
   // a la place de as Array --> On peut mettre : getAuthorities();
    }
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(new UserInfo().getRole());
		return Arrays.asList(authority);
    }
//
//    public Collection<? extends GrantedAuthority> getAuthorities2() {
//        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        for (final Role role: user.getRoles())
//            authorities.add(new SimpleGrantedAuthority(role.getTitre()));
//        return authorities;
//    }
//methodes pour tansformer liste de roles
//
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Rol> roles){
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }
//return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
}
