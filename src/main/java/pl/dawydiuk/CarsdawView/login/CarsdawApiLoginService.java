package pl.dawydiuk.CarsdawView.login;

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
public class CarsdawApiLoginService {

    private static final Logger log = LoggerFactory.getLogger(CarsdawApiLoginService.class);
    private final RestTemplate restTemplate;
    private static final String GET_TOKEN_URL = "/login";
    private final ServicesProps servicesProps;

    public ResponseEntity<String> getToken(LoginCredentials loginCredentials) {
        log.info("Module CarsdawRestApi- get token execute");
        return restTemplate.exchange(servicesProps.getCarsdawApiService() + GET_TOKEN_URL, HttpMethod.POST,
                new HttpEntity<>(createBody(loginCredentials.getUsername(), loginCredentials.getPassword())), String.class);
    }

    private String createBody(String username, String password) {
        return """
                {   "username":"%s",   "password":"%s"}
                """.formatted(username, password);


    }

    public ResponseEntity<String> reliable() {
        return new ResponseEntity<>("Service unavailable please try again", HttpStatus.SERVICE_UNAVAILABLE);
    }


}
