package ua.company.myroniuk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.company.myroniuk.entity.User;
import javax.validation.Valid;

/**
 * @author Vitalii Myroniuk
 */
@Controller
public class HomeController {
    private static final Integer WEAK_STRENGTH = 1;
    private static final Integer MIDDLE_STRENGTH = 5;
    private static final Integer STRONG_STRENGTH = 7;

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
    public String userPage(@Valid @ModelAttribute(name = "user") User user,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        redirectAttributes.addFlashAttribute("user", user);
        return "redirect:/home";
    }

    @RequestMapping(path="/json/get-user/{login}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getJsonUser(@PathVariable(name = "login") String login,
                            @RequestParam(name = "name") String name) {
        User user = new User();
        user.setLogin(login);
        user.setName(name);
        return user;
    }

    @RequestMapping(path="/json/post-user", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> setJsonUser(@RequestBody User user) {
        if (user.getLogin() == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path="/check_password_strength", method = RequestMethod.GET, produces = {"text/html; charset-UTF-8"})
    @ResponseBody
    public String checkPasswordStrength(@RequestParam String password) {
        int length = password.length();
        if (WEAK_STRENGTH <= length &&  length < MIDDLE_STRENGTH) {
            return "weak";
        } else if (MIDDLE_STRENGTH <= length &&  length < STRONG_STRENGTH) {
            return "middle";
        } else if (STRONG_STRENGTH <= length) {
            return "strong";
        } else {
            return "<br>";
        }
    }

}
