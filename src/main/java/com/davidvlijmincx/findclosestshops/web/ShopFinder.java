package com.davidvlijmincx.findclosestshops.web;

import com.davidvlijmincx.findclosestshops.Store;
import com.davidvlijmincx.findclosestshops.StoreLocator.Locator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/find-store")
public class ShopFinder {

    @GetMapping("lat-long/{latitude}/{longitude}")
    ResponseEntity<List<Store>> throwException(@PathVariable double latitude, @PathVariable double longitude) {
        if (latitude > 90 || latitude < -90) {
            throw new LatitudeNotValid(90);
        }
        if (longitude > 180 || longitude < -180) {
           throw new LongitudeNotValid(longitude);
        }


        List<Store> closestStore = Locator.INSTANCE.findClosestStore(latitude, longitude);

        return ResponseEntity.ok(closestStore);
    }

}
