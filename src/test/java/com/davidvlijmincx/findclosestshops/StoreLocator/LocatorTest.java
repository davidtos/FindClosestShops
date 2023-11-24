package com.davidvlijmincx.findclosestshops.StoreLocator;

import com.davidvlijmincx.findclosestshops.Store;
import com.davidvlijmincx.findclosestshops.external.StoreLoader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class LocatorTest {

    @Test
    void findClosestStore(){
        try (var mocked = mockStatic(StoreLoader.class)) {

            var stores = List.of(
                    createStore(1, 1),
                    createStore(2, 1),
                    createStore(3, 1),
                    createStore(4, 1),
                    createStore(5, 1),
                    createStore(6, 1));

            when(StoreLoader.loadStores()).thenReturn(stores);

            List<Store> result = Locator.INSTANCE.findClosestStore(1, 1);

            assertThat(result).hasSize(5);
            assertThat(result).containsExactly(stores.subList(0,5).toArray(new Store[5]));
        }
    }




    private Store createStore(double latitude, double longitude){
        return new Store("","","","","",longitude,latitude,true);
    }

}