package com.san.carteleraextviam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CarteleraExtViamApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarteleraExtViamApplication.class, args);
    }

}
