package com.davidvlijmincx.findclosestshops.external;

import java.util.Arrays;
import java.util.List;

public record Stores(Store[] stores) {

    List<com.davidvlijmincx.findclosestshops.Store> toDomain() {

        return Arrays.stream(stores).map(Store::toDomain).toList();
    }
}
