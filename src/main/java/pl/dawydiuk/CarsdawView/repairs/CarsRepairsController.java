package pl.dawydiuk.CarsdawView.repairs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarsRepairsController {

    private final CarsdawApiRepairsService service;

    public CarsRepairsController(CarsdawApiRepairsService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public ModelAndView getRepairsTable() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("allRepairs", service.getAllCarRepairs().getBody());
        return modelAndView;
    }
}
