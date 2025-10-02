package org.skypro.skyshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkyshopApplication {
    // for Example url: http://localhost:8080/search?pattern=apples
    public static void main(String[] args) {
        SpringApplication.run(SkyshopApplication.class, args);
    }
}
