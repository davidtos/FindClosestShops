package com.davidvlijmincx.findclosestshops.web;

import com.davidvlijmincx.findclosestshops.FindClosestShopsApplication;
import com.davidvlijmincx.findclosestshops.Store;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = FindClosestShopsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShopFinderIT {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void testAddEmployee() {
        ResponseEntity<Store[]> responseEntity = this.restTemplate
                .getForEntity("http://localhost:" + port + "/v1/find-store/lat-long/51.6158/80", Store[].class);

        Store[] body = responseEntity.getBody();
        assertEquals(body.length, 5);
        assertEquals(200, responseEntity.getStatusCode().value());
    }



}