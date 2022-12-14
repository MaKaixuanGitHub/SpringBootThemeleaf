package com.kuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.kuang.mapper"})
@EnableOAuth2Sso
public class Springboot03WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03WebApplication.class, args);
    }

}
