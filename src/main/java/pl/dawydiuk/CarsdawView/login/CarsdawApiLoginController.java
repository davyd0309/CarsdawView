package pl.dawydiuk.CarsdawView.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarsdawApiLoginController {

    private final CarsdawApiLoginService loginService;
    private final JwtCache jwtCache;

    public CarsdawApiLoginController(CarsdawApiLoginService loginService) {
        this.loginService = loginService;
        this.jwtCache = JwtCache.JWT_CACHE;
    }

    @GetMapping()
    public ModelAndView showLoginPage() {
        return new ModelAndView("login");
    }

    @PostMapping("/token")
    public ModelAndView getToken(@RequestParam String username, @RequestParam String password) {
        String jwt = jwtCache.fetchJwt(() -> loginService.getToken(new LoginCredentials(username, password)).getBody());
        return !jwt.isEmpty() ?
                new ModelAndView("redirect:/index") : new ModelAndView("error");
    }


}
