package ua.edu.chnu.springjpaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    /**
     * Головна сторінка
     */
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Головна сторінка");
        return "index";
    }

    /**
     * Сторінка реєстрації
     */
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new ua.edu.chnu.springjpaproject.user.dto.UserRegistrationDto());
        model.addAttribute("errors", new java.util.HashMap<String, String>());
        return "register";
    }
}