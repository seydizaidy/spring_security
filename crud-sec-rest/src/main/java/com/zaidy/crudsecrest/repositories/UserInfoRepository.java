package com.zaidy.crudsecrest.repositories;


import com.zaidy.crudsecrest.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,String>
{
    UserInfo findByUsername(String username);
}
