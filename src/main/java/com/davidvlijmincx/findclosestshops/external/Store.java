package com.davidvlijmincx.findclosestshops.external;

public record Store(
        String city,
        String postalCode,
        String street,
        String street2,
        String street3,
        String addressName,
        String uuid,
        String longitude,
        String latitude,
        String complexNumber,
        boolean showWarningMessage,
        String todayOpen,
        String locationType,
        boolean collectionPoint,
        String sapStoreID,
        String todayClose){

    com.davidvlijmincx.findclosestshops.Store toDomain(){
        return new com.davidvlijmincx.findclosestshops.Store(city,postalCode,street,street2,addressName, Double.parseDouble(longitude),Double.parseDouble(latitude),collectionPoint);
    }
}


