package ua.company.myroniuk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.company.myroniuk.entity.User;
import javax.validation.Valid;

/**
 * @author Vitalii Myroniuk
 */
@Controller
public class HomeController {

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String userPage(@Valid @ModelAttribute(name = "user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        model.addAttribute("user", user);
        return "home";
    }

}
