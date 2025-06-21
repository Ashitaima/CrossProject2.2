package ua.edu.chnu.springjpaproject.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Знайти користувача за ім'ям користувача (username)
     */
    Optional<User> findByUsername(String username);

    /**
     * Перевірити чи існує користувач з таким ім'ям
     */
    boolean existsByUsername(String username);

    /**
     * Знайти користувачів за роллю
     */
    List<User> findByRole(UserRole role);

    /**
     * Знайти користувачів за частиною імені (пошук)
     */
    List<User> findByUsernameContainingIgnoreCase(String username);

    /**
     * Отримати кількість користувачів за роллю
     */
    @Query("SELECT COUNT(u) FROM User u WHERE u.role = :role")
    long countByRole(@Param("role") UserRole role);

    /**
     * Знайти останніх зареєстрованих користувачів
     */
    @Query("SELECT u FROM User u ORDER BY u.createdAt DESC")
    List<User> findLatestUsers();

    /**
     * Знайти користувачів зареєстрованих після певної дати
     */
    @Query("SELECT u FROM User u WHERE u.createdAt >= :date ORDER BY u.createdAt DESC")
    List<User> findUsersRegisteredAfter(@Param("date") java.time.LocalDateTime date);
}