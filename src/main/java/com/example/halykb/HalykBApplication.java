package com.example.halykb;

import com.example.halykb.entity.Users;
import com.example.halykb.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@EnableJpaRepositories
@SpringBootApplication
public class HalykBApplication {

    public static void main(String[] args) {
        SpringApplication.run(HalykBApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner (UserRepo userRepo) {
        return args -> {
            Users user = new Users(1L, "Murzaliev Eldiiar Azamatovich", new Date(), "admin");

            userRepo.save(user);
        };
    }
}
