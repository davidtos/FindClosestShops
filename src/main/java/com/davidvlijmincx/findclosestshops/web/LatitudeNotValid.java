package com.davidvlijmincx.findclosestshops.web;

public class LatitudeNotValid extends RuntimeException {

    private final double latitude;

    public LatitudeNotValid(double latitude) {
        this.latitude = latitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
