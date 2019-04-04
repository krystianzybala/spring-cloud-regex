package com.krystianzybala.spcontract;

import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@SpringBootApplication
public class SpcontractregApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpcontractregApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

@RestController
@RequestMapping(path = "/api/v1/security")
class SecurityController {

    private final RestTemplate restTemplate;

    SecurityController(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Privilege getPrivilege() {

        final User user = this.restTemplate.getForObject("http://localhost:9000/api/v1/users/", User.class);

        return new Privilege(user.getId());
    }
}

@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
class Privilege {
    private UUID id;
}

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
class User {
    private UUID id;
}