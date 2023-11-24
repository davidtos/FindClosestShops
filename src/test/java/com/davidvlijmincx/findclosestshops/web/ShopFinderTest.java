package com.davidvlijmincx.findclosestshops.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


class ShopFinderTest {

    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new ShopFinder())
                .setControllerAdvice(AdviceController.class)
                .build();
    }

    @Test
    void longitudeToHigh() throws Exception {
        this.mockMvc.perform(get("/v1/find-store/lat-long/51.6158/900")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(jsonPath("detail").value("LongitudeNotValid is not valid! Should be between -180 and 180 and was 900.0"));
    }

    @Test
    void longitudeToLow() throws Exception {
        this.mockMvc.perform(get("/v1/find-store/lat-long/51.6158/-900")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is4xxClientError())
        .andExpect(jsonPath("detail").value("LongitudeNotValid is not valid! Should be between -180 and 180 and was -900.0"));
    }


    @Test
    void latitudeToHigh() throws Exception {
        this.mockMvc.perform(get("/v1/find-store/lat-long/900/9")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(jsonPath("detail").value("Latitude is not valid! Should be between -90 and 90 and was 90.0"));
    }

    @Test
    void latitudeToLow() throws Exception {
        this.mockMvc.perform(get("/v1/find-store/lat-long/-900/9")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(jsonPath("detail").value("Latitude is not valid! Should be between -90 and 90 and was 90.0"));
    }


    @Test
    void getShopsSuccessfully() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/v1/find-store/lat-long/51.6158/9")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

}