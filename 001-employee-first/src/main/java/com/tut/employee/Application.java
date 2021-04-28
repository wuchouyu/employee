package com.tut.employee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

<<<<<<< HEAD
//exclude = {SecurityAutoConfiguration.class}
@SpringBootApplication()
=======

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
@MapperScan(basePackages = "com.tut.employee.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
