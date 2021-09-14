package com.oven;

import com.oven.case13.Restaurant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OvenApplication {

    public static void main(String[] args) {
        SpringApplication.run(OvenApplication.class, args);

        Restaurant bakery = new Restaurant("Bakery");
        bakery.cook("cookies");
    }

}
