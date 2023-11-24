package com.davidvlijmincx.findclosestshops.StoreLocator;

import com.davidvlijmincx.findclosestshops.Store;
import com.davidvlijmincx.findclosestshops.external.StoreLoader;

import java.util.Comparator;
import java.util.List;

public enum Locator {
    INSTANCE;

    private final List<Store> stores;

    Locator() {
        this.stores = StoreLoader.loadStores();
    }

    private double haversineDistance(Store p1, double p2Latitude, double p2Longitude) {
        // distance between latitudes and longitudes
        double dLat = Math.toRadians(p2Latitude - p1.latitude());
        double dLon = Math.toRadians(p2Longitude - p1.longitude());

        // convert to radians
        var lat1 = Math.toRadians(p1.latitude());
        var lat2 = Math.toRadians(p2Latitude);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }

    public List<Store> findClosestStore(double latitude, double longitude) {
       return stores.stream()
                .map(store -> new StoreDistance(store, haversineDistance(store,latitude,longitude)))
                .sorted(Comparator.comparingDouble(d -> d.distance)).limit(5)
               .map(storeDistance -> storeDistance.store).toList();
    }

    record StoreDistance(Store store, double distance){}

}
