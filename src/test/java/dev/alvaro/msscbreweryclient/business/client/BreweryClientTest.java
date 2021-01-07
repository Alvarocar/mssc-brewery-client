package dev.alvaro.msscbreweryclient.business.client;

import dev.alvaro.msscbreweryclient.model.dto.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void testGetBeerById() {
        Beer beer = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beer);
    }

    @Test
    void testSaveNewBeer() {
        Beer beer = Beer.builder().beerName("Duff").build();
        URI uriNewBeer = breweryClient.saveNewBeer(beer);
        assertNotNull(uriNewBeer);
        System.out.println(uriNewBeer.toString());
    }
}