package ua.edu.chnu.springjpaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.edu.chnu.springjpaproject.repository.UserRepository;
import ua.edu.chnu.springjpaproject.user.User;
import ua.edu.chnu.springjpaproject.user.UserRole;
import ua.edu.chnu.springjpaproject.user.dto.UserRegistrationDto;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * Реєстрація нового користувача
     */
    public User registerUser(UserRegistrationDto registrationDto) {
        // Перевірка чи існує користувач з таким ім'ям
        if (userRepository.existsByUsername(registrationDto.getUsername())) {
            throw new RuntimeException("Користувач з таким ім'ям вже існує");
        }

        // Перевірка чи співпадають паролі
        if (!registrationDto.isPasswordsMatch()) {
            throw new RuntimeException("Паролі не співпадають");
        }

        // Створення нового користувача
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRole(UserRole.USER);

        return userRepository.save(user);
    }

    /**
     * Знайти користувача за ім'ям
     */
    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Отримати всіх користувачів
     */
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Отримати користувачів за роллю
     */
    @Transactional(readOnly = true)
    public List<User> getUsersByRole(UserRole role) {
        return userRepository.findByRole(role);
    }

    /**
     * Пошук користувачів за ім'ям
     */
    @Transactional(readOnly = true)
    public List<User> searchUsers(String searchTerm) {
        return userRepository.findByUsernameContainingIgnoreCase(searchTerm);
    }

    /**
     * Перевірка чи існує користувач з таким ім'ям
     */
    @Transactional(readOnly = true)
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    /**
     * Отримати кількість користувачів
     */
    @Transactional(readOnly = true)
    public long getUserCount() {
        return userRepository.count();
    }

    /**
     * Отримати кількість користувачів за роллю
     */
    @Transactional(readOnly = true)
    public long getUserCountByRole(UserRole role) {
        return userRepository.countByRole(role);
    }

    /**
     * Перевірка паролю
     */
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}