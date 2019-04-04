package com.krystianzybala.spcontract;


import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "server.port=0",
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids="com.krystianzybala:spcontract-producer:+:9000")
public class SpcontractregApplicationTests {


    @Autowired
    private SecurityController securityController;

    @Test
    public void contextLoads() {
    }

    @LocalServerPort
    long port;


    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost:" + port;


        RestAssuredMockMvc.standaloneSetup(securityController)
        ;
    }

}
