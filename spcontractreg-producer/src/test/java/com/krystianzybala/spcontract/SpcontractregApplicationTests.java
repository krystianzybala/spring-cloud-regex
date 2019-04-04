package com.krystianzybala.spcontract;

import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "server.port=0",
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMessageVerifier
public class SpcontractregApplicationTests {

    @Autowired
    private UserController userController;

    @Test
    public void contextLoads() {
    }

    @LocalServerPort
    long port;


    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost:" + port;


        RestAssuredMockMvc.standaloneSetup(userController)
        ;
    }

}
