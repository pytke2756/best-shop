package com.shop.best.shop.config;

import com.shop.best.shop.model.User;
import com.shop.best.shop.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User user1 = new User("John", "Doe", "123", false, "Budapest", "Váci út");
            User user2 = new User("Alex", "Doe", "321", true, "Budapest", "Akácfa utca");

            userRepository.saveAll(List.of(user1, user2));
        };
    }
}