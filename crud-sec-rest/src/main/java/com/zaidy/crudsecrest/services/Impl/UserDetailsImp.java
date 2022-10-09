package com.zaidy.crudsecrest.services.Impl;

import com.zaidy.crudsecrest.model.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImp implements UserDetails
{
    private UserInfo userInfo;
    public UserDetailsImp(UserInfo userInfo){
        this.userInfo = userInfo;
    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        for (final Role role: user.getRoles())
//            authorities.add(new SimpleGrantedAuthority(role.getTitre()));
//        return authorities;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
