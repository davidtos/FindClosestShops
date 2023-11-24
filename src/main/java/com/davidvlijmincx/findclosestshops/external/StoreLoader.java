package com.davidvlijmincx.findclosestshops.external;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;


public class StoreLoader {

    public static List<com.davidvlijmincx.findclosestshops.Store> loadStores() {
        ClassPathResource resource = new ClassPathResource("static/stores.json");
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Stores stores;
        try {
            stores = mapper.readValue(resource.getFile(), Stores.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stores.toDomain();
    }

}
