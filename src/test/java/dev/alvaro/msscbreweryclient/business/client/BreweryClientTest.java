package dev.alvaro.msscbreweryclient.business.client;

import dev.alvaro.msscbreweryclient.model.dto.Beer;
import dev.alvaro.msscbreweryclient.model.dto.Customer;
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
    }

    @Test
    void testUpdateBeer() {
        Beer beer = Beer.builder().id(UUID.randomUUID()).beerName("Duff").build();
        breweryClient.updateBeer(beer);
    }

    @Test
    void testDeleteBeer(){
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void testGetCustomerById() {
        Customer customer = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customer);
    }

    @Test
    void testSaveNewCustomer() {
        Customer customer = Customer.builder().name("Alvaro").build();
        URI uriNewCustomer = breweryClient.saveNewCustomer(customer);
        assertNotNull(uriNewCustomer);
        System.out.println(uriNewCustomer.toString());
    }

    @Test
    void testUpdateCustomer() {
        Customer customer = Customer.builder().name("Alvaro").build();
        breweryClient.updateCustomer(customer);
    }

    @Test
    void testDeleteCustomer() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}