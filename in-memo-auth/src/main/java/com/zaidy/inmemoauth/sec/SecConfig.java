package com.zaidy.inmemoauth.sec;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration  @EnableWebSecurity
public class SecConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication().withUser("seydi").password("{noop}seydi")
                .roles("USER").
                and()
                .
                withUser("admin")
                .password("{noop}admin").
                credentialsExpired(true).
                accountExpired(true)
                .accountLocked(true)
                .authorities("WRITE_PRIVILEGES", "READ_PRIVILEGES").roles("ADMIN");
    }

}
