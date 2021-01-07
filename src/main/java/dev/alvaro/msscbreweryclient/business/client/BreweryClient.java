package dev.alvaro.msscbreweryclient.business.client;

import dev.alvaro.msscbreweryclient.model.dto.Beer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "dev.alvaro", ignoreUnknownFields = false)
public class BreweryClient {

    private String apihost;
    private final String beerPathV1 = "/api/v1/beer/";
    private RestTemplate restTemplate;


    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Beer getBeerById(UUID uuid) {
        return restTemplate.getForObject(apihost + beerPathV1 + uuid.toString(), Beer.class);
    }

    public URI saveNewBeer(Beer beer){
        return restTemplate.postForLocation( apihost + beerPathV1, beer);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
