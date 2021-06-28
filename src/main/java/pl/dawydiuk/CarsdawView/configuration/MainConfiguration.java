package pl.dawydiuk.CarsdawView.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.dawydiuk.CarsdawView.login.CarsdawApiLoginService;
import pl.dawydiuk.CarsdawView.login.JwtCache;
import pl.dawydiuk.CarsdawView.properties.ServicesProps;
import pl.dawydiuk.CarsdawView.repairs.CarsdawApiRepairsService;

@Configuration
public class MainConfiguration {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .build();
    }

    @Bean
    public CarsdawApiRepairsService carsdawApiRepairsService(RestTemplate restTemplate, ServicesProps servicesProps) {
        return new CarsdawApiRepairsService(restTemplate, servicesProps, JwtCache.JWT_CACHE);
    }

    @Bean
    public CarsdawApiLoginService carsdawApiLoginService(RestTemplate restTemplate, ServicesProps servicesProps) {
        return new CarsdawApiLoginService(restTemplate, servicesProps);
    }
}
