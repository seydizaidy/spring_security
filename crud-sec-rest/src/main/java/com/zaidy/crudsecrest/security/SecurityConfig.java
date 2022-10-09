package com.zaidy.crudsecrest.security;

import com.zaidy.crudsecrest.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{


    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private AppAuthenticationEntryPoint appAuthenticationEntryPoint;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userInfoService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
   // @Autowired
    // we can use override with configure methode
   public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userInfoService).passwordEncoder(passwordEncoder());


    }
    // Configuring the api
    // according to the roles.
    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
            .and().httpBasic().realmName("MY APP REALM")
            .authenticationEntryPoint(appAuthenticationEntryPoint);
    }

    // Function to encode the password
    // assign to the particular roles.

    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}

//    @Bean
//    public UserDetailsService userDetailsService()
//    {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user").password("password").roles("USER").build());
//        manager.createUser(User.withUsername("admin").password("password").roles("USER","ADMIN").build());
//        return manager;
//    }


//// In memory Auth
//protected void configure(Authentic    ationManagerBuilder auth) throws Exception
//{
////        auth.inMemoryAuthentication()
////                .withUser("seydi")
////                .password("seydi").roles("admin")
////
////                .and()
////                .withUser("student")
////                .password("student")
////                .roles("student");
//
//}
//
//#
//        #The class has been annotated with @EnableWebSecurity that configures spring security from the class
//        WebSecurityConfigurer. If we want to override any method of WebSecurityConfigurer then we extend
//        WebSecurityConfigurerAdapter.\
//#   In our example to configure HttpSecurity we have overridden configure() method. Here we have
//authorized a URL with /user/** pattern.
// We will also configure implementation class of BasicAuthenticationEntryPoint here.
// #Now autowire method configureGlobal() within which we configure implementation class of
// UserDetailsService with BCryptPasswordEncoder encoding scheme.
// #To secure service methods we need to use @EnableGlobalMethodSecurity annotation.
// To enable method level security with @Secured annotation, configure securedEnabled metadata with value true. To enable @PreAuthorize and @PostAuthorize annotation, configure prePostEnabled metadata with value true
// #*/