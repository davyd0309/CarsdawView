package pl.dawydiuk.CarsdawView.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "services")
public class ServicesProps {

    @Setter
    @Getter
    private String carsdawApiService;
}
