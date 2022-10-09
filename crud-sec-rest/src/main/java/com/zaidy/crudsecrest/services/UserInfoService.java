package com.zaidy.crudsecrest.services;

import com.zaidy.crudsecrest.model.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserInfoService extends UserDetailsService
{
    UserInfo createUser(UserInfo userInfo);

}
