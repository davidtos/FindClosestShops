package com.davidvlijmincx.findclosestshops;

public record Store(
        String city,
        String postalCode,
        String street,
        String street2,
        String addressName,
        double longitude,
        double latitude,
        boolean collectionPoint)
{

}

