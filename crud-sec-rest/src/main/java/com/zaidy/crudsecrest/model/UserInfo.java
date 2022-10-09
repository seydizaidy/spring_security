package com.zaidy.crudsecrest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="users")
@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class UserInfo implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "country")
    private String country;
    @Column(name = "enabled")
    private short enabled;
}