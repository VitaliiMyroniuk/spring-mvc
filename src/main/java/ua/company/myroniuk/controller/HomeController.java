package ua.company.myroniuk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Vitalii Myroniuk
 */
@Controller
public class HomeController {

    @RequestMapping(path = {"/", "/home"}, method = RequestMethod.GET)
    public String showHomePage(Model model) {
        model.addAttribute("message", "Hello World!");
        return "home";
    }

}
