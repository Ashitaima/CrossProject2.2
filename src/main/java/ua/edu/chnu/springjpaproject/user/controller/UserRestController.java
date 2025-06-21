package ua.edu.chnu.springjpaproject.user.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.edu.chnu.springjpaproject.user.User;
import ua.edu.chnu.springjpaproject.user.UserService;
import ua.edu.chnu.springjpaproject.user.dto.UserRegistrationDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Реєстрація нового користувача (POST запит з форми)
     */
    @PostMapping("/register")
    public String registerUser(
            @Valid @ModelAttribute UserRegistrationDto registrationDto,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        try {
            // Збираємо помилки валідації
            Map<String, String> errors = new HashMap<>();

            if (bindingResult.hasErrors()) {
                bindingResult.getFieldErrors().forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage())
                );
            }

            // Перевірка унікальності username
            if (userService.existsByUsername(registrationDto.getUsername())) {
                errors.put("username", "Користувач з таким ім'ям вже існує");
            }

            // Перевірка співпадіння паролів
            if (!registrationDto.isPasswordsMatch()) {
                errors.put("confirmPassword", "Паролі не співпадають");
            }

            // Якщо є помилки, повертаємо форму з помилками
            if (!errors.isEmpty()) {
                model.addAttribute("user", registrationDto);
                model.addAttribute("errors", errors);
                return "register";
            }

            // Реєстрація користувача
            User savedUser = userService.registerUser(registrationDto);

            // Перенаправлення з повідомленням про успіх
            redirectAttributes.addAttribute("success", "true");
            return "redirect:/register";

        } catch (Exception e) {
            // Обробка помилок
            Map<String, String> errors = new HashMap<>();
            errors.put("general", "Помилка реєстрації: " + e.getMessage());

            model.addAttribute("user", registrationDto);
            model.addAttribute("errors", errors);
            return "register";
        }
    }

    /**
     * REST API для отримання всіх користувачів
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * REST API для перевірки доступності username
     */
    @GetMapping("/check-username")
    @ResponseBody
    public ResponseEntity<Map<String, Boolean>> checkUsername(@RequestParam String username) {
        boolean exists = userService.existsByUsername(username);
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        response.put("available", !exists);
        return ResponseEntity.ok(response);
    }

    /**
     * REST API для отримання статистики користувачів
     */
    @GetMapping("/stats")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getUserStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalUsers", userService.getUserCount());
        stats.put("adminUsers", userService.getUserCountByRole(ua.edu.chnu.springjpaproject.user.UserRole.ADMIN));
        stats.put("regularUsers", userService.getUserCountByRole(ua.edu.chnu.springjpaproject.user.UserRole.USER));
        return ResponseEntity.ok(stats);
    }
}