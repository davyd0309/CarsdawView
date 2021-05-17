package pl.dawydiuk.CarsdawView.repairs;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.dawydiuk.CarsdawView.properties.ServicesProps;

@RequiredArgsConstructor
public class CarsdawApiRepairsService {

    private static final Logger log = LoggerFactory.getLogger(CarsdawApiRepairsService.class);
    private final RestTemplate restTemplate;
    private static final String GET_ALL_REPAIRS_URL = "/repairs";
    private final ServicesProps servicesProps;

    public ResponseEntity<String> getAllCarRepairs() {
        log.info("Module with repairs called");
        return restTemplate.exchange(servicesProps.getCarsdawApiService() + GET_ALL_REPAIRS_URL, HttpMethod.GET, HttpEntity.EMPTY, String.class);
    }

    public ResponseEntity<String> reliable() {
        return new ResponseEntity<>("Service unavailable please try again", HttpStatus.SERVICE_UNAVAILABLE);
    }
}
