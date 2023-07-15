package com.github.bibek77;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ${USER}
 */
@SpringBootApplication
public class TwitterToKafkaService implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaService.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application has stated !!!");
    }

}