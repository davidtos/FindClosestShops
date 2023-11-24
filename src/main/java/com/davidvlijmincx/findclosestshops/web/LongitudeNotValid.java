package com.davidvlijmincx.findclosestshops.web;

public class LongitudeNotValid extends RuntimeException {

    private final double longitude;

    public LongitudeNotValid(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
