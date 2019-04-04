package com.krystianzybala.spcontract;

import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
public class SpcontractregApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpcontractregApplication.class, args);
    }


}

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
class User {
    private UUID id;
}

@RestController
@RequestMapping(path = "/api/v1/users")
class UserController {

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUser() {
        return new User(UUID.randomUUID());
    }
}