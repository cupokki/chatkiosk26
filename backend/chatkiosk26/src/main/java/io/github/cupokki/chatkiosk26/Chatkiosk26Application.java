package io.github.cupokki.chatkiosk26;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class Chatkiosk26Application {

    public static void main(String[] args) {
        SpringApplication.run(Chatkiosk26Application.class, args);
    }

}
