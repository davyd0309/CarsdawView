package pl.dawydiuk.CarsdawView.repairs;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import pl.dawydiuk.CarsdawView.login.JwtCache;
import pl.dawydiuk.CarsdawView.properties.ServicesProps;

@RequiredArgsConstructor
public class CarsdawApiRepairsService {

    private static final Logger log = LoggerFactory.getLogger(CarsdawApiRepairsService.class);
    private final RestTemplate restTemplate;
    private static final String GET_ALL_REPAIRS_URL = "/repairs";
    private final ServicesProps servicesProps;
    private final JwtCache jwtCache;

    public ResponseEntity<String> getAllCarRepairs() {
        log.info("Module CarsdawRestApi execute");
        return restTemplate.exchange(servicesProps.getCarsdawApiService() + GET_ALL_REPAIRS_URL, HttpMethod.GET, crateHeader(jwtCache.getJwt()), String.class);
    }

    public ResponseEntity<String> reliable() {
        return new ResponseEntity<>("Service unavailable please try again", HttpStatus.SERVICE_UNAVAILABLE);
    }

    private HttpEntity<String> crateHeader(String token) {
        String jwt = "Bearer " + token;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", jwt);
        return new HttpEntity<>(headers);
    }

}
