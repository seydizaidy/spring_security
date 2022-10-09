package com.zaidy.crudsecrest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Slf4j
@SpringBootApplication
public class CrudSecRestApplication implements CommandLineRunner {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(CrudSecRestApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
         {
             //log.info(bCryptPasswordEncoder.encode("123"));

        }
    }
}
