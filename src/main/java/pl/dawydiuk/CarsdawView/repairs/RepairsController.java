package pl.dawydiuk.CarsdawView.repairs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RepairsController {

    private CarsdawApiRepairsService service;

    @GetMapping()
    public ModelAndView getRepairsTable() {
//        service.getAllCarRepairs().getBody()
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("name", "xxxxxxxxxxxx");
        return modelAndView;
    }
}
