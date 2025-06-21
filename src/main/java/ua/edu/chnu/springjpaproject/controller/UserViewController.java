package ua.edu.chnu.springjpaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.chnu.springjpaproject.user.dto.UserRegistrationDto;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserViewController {

    @GetMapping("/register")
    public String showRegistrationForm(
            Model model,
            @RequestParam(value = "success", required = false) String success,
            @RequestParam(value = "error", required = false) String error
    ) {
        // Додаємо порожній DTO для форми
        model.addAttribute("user", new UserRegistrationDto());

        // Додаємо порожню мапу помилок
        model.addAttribute("errors", new HashMap<String, String>());

        // Додаємо повідомлення про успіх, якщо є
        if ("true".equals(success)) {
            model.addAttribute("successMessage", "Користувач успішно зареєстрований!");
        }

        // Додаємо повідомлення про помилку, якщо є
        if (error != null && !error.isEmpty()) {
            Map<String, String> errors = new HashMap<>();
            errors.put("general", error);
            model.addAttribute("errors", errors);
        }

        return "register";
    }
}