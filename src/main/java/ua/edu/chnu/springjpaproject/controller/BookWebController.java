package ua.edu.chnu.springjpaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.edu.chnu.springjpaproject.model.Author;
import ua.edu.chnu.springjpaproject.model.Book;
import ua.edu.chnu.springjpaproject.model.Category;
import ua.edu.chnu.springjpaproject.service.AuthorService;
import ua.edu.chnu.springjpaproject.service.BookService;
import ua.edu.chnu.springjpaproject.service.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/books")
public class BookWebController {

    private static final Logger logger = Logger.getLogger(BookWebController.class.getName());

    private final BookService bookService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired
    public BookWebController(BookService bookService,
                             AuthorService authorService,
                             CategoryService categoryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    // Сторінка зі списком книг
    @GetMapping
    public String listBooks(Model model) {
        try {
            logger.info("Отримання списку всіх книг");
            List<Book> books = bookService.getAllBooks();
            model.addAttribute("books", books != null ? books : new ArrayList<>());
            return "books";
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Помилка при отриманні списку книг", e);
            model.addAttribute("books", new ArrayList<>());
            model.addAttribute("errorMessage", "Виникла помилка при завантаженні книг: " + e.getMessage());
            return "books";
        }
    }

    // Сторінка додавання нової книги
    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        try {
            logger.info("Відображення форми додавання книги");

            // Отримання списку авторів
            logger.info("Отримання списку авторів");
            List<Author> authors = authorService.getAllAuthors();
            logger.info("Отримано авторів: " + (authors != null ? authors.size() : 0));

            // Отримання списку категорій
            logger.info("Отримання списку категорій");
            List<Category> categories = categoryService.getAllCategories();
            logger.info("Отримано категорій: " + (categories != null ? categories.size() : 0));

            // Додавання списків до моделі
            model.addAttribute("authors", authors != null ? authors : new ArrayList<>());
            model.addAttribute("categories", categories != null ? categories : new ArrayList<>());

            return "book-add";
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Помилка при відображенні форми додавання книги", e);
            model.addAttribute("errorMessage", "Виникла помилка: " + e.getMessage());
            model.addAttribute("authors", new ArrayList<>());
            model.addAttribute("categories", new ArrayList<>());
            return "book-add";
        }
    }

    // Обробка форми додавання нової книги
    @PostMapping("/add")
    public String addBook(@RequestParam("title") String title,
                          @RequestParam("isbn") String isbn,
                          @RequestParam(value = "publicationYear", required = false) Integer publicationYear,
                          @RequestParam(value = "pages", required = false) Integer pages,
                          @RequestParam("authorId") Long authorId,
                          @RequestParam("categoryId") Long categoryId,
                          @RequestParam(value = "description", required = false) String description,
                          Model model,
                          RedirectAttributes redirectAttributes) {

        try {
            logger.info("Додавання нової книги: " + title);

            // Отримуємо автора
            logger.info("Отримання автора з ID: " + authorId);
            Optional<Author> author = authorService.getAuthorById(authorId);
            if (author.isEmpty()) {
                throw new RuntimeException("Автор з ID " + authorId + " не знайдений");
            }

            // Отримуємо категорію
            logger.info("Отримання категорії з ID: " + categoryId);
            Optional<Category> category = categoryService.getCategoryById(categoryId);
            if (category.isEmpty()) {
                throw new RuntimeException("Категорія з ID " + categoryId + " не знайдена");
            }

            // Створюємо нову книгу
            Book book = new Book();
            book.setTitle(title);
            book.setIsbn(isbn != null && !isbn.trim().isEmpty() ? isbn : null);
            book.setPublicationYear(publicationYear);
            book.setPages(pages);
            book.setAuthor(author.get());
            book.setCategory(category.get());
            book.setDescription(description != null && !description.trim().isEmpty() ? description : null);

            // Зберігаємо книгу в базі даних
            logger.info("Збереження книги в базі даних");
            bookService.saveBook(book);

            // Додаємо повідомлення про успіх
            redirectAttributes.addFlashAttribute("successMessage",
                    "Книга \"" + title + "\" успішно додана!");

            return "redirect:/books";

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Помилка при додаванні книги", e);

            // У випадку помилки повертаємося на форму з повідомленням про помилку
            try {
                List<Author> authors = authorService.getAllAuthors();
                List<Category> categories = categoryService.getAllCategories();

                model.addAttribute("authors", authors != null ? authors : new ArrayList<>());
                model.addAttribute("categories", categories != null ? categories : new ArrayList<>());
            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Помилка при отриманні авторів та категорій", ex);
                model.addAttribute("authors", new ArrayList<>());
                model.addAttribute("categories", new ArrayList<>());
            }

            model.addAttribute("errorMessage", "Помилка: " + e.getMessage());
            return "book-add";
        }
    }

    // Сторінка перегляду деталей книги
    @GetMapping("/view/{id}")
    public String viewBook(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            logger.info("Перегляд деталей книги з ID: " + id);

            Optional<Book> bookOpt = bookService.getBookById(id);
            if (bookOpt.isEmpty()) {
                logger.warning("Книга з ID " + id + " не знайдена");
                redirectAttributes.addFlashAttribute("errorMessage", "Книга з ID " + id + " не знайдена");
                return "redirect:/books";
            }

            model.addAttribute("book", bookOpt.get());
            return "book-view";
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Помилка при перегляді деталей книги", e);
            redirectAttributes.addFlashAttribute("errorMessage", "Помилка при перегляді деталей книги: " + e.getMessage());
            return "redirect:/books";
        }
    }

    // Сторінка редагування книги
    @GetMapping("/edit/{id}")
    public String showEditBookForm(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            logger.info("Відображення форми редагування книги з ID: " + id);

            Optional<Book> bookOpt = bookService.getBookById(id);
            if (bookOpt.isEmpty()) {
                logger.warning("Книга з ID " + id + " не знайдена");
                redirectAttributes.addFlashAttribute("errorMessage", "Книга з ID " + id + " не знайдена");
                return "redirect:/books";
            }

            List<Author> authors = authorService.getAllAuthors();
            List<Category> categories = categoryService.getAllCategories();

            model.addAttribute("book", bookOpt.get());
            model.addAttribute("authors", authors != null ? authors : new ArrayList<>());
            model.addAttribute("categories", categories != null ? categories : new ArrayList<>());

            return "book-edit";
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Помилка при відображенні форми редагування книги", e);
            redirectAttributes.addFlashAttribute("errorMessage", "Помилка при відображенні форми редагування книги: " + e.getMessage());
            return "redirect:/books";
        }
    }

    // Обробка форми редагування книги
    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable("id") Long id,
                            @RequestParam("title") String title,
                            @RequestParam("isbn") String isbn,
                            @RequestParam(value = "publicationYear", required = false) Integer publicationYear,
                            @RequestParam(value = "pages", required = false) Integer pages,
                            @RequestParam("authorId") Long authorId,
                            @RequestParam("categoryId") Long categoryId,
                            @RequestParam(value = "description", required = false) String description,
                            Model model,
                            RedirectAttributes redirectAttributes) {
        try {
            logger.info("Оновлення книги з ID: " + id);

            // Перевіряємо, чи існує книга
            Optional<Book> bookOpt = bookService.getBookById(id);
            if (bookOpt.isEmpty()) {
                logger.warning("Книга з ID " + id + " не знайдена");
                redirectAttributes.addFlashAttribute("errorMessage", "Книга з ID " + id + " не знайдена");
                return "redirect:/books";
            }

            Book book = bookOpt.get();

            // Отримуємо автора та категорію
            Optional<Author> author = authorService.getAuthorById(authorId);
            if (author.isEmpty()) {
                throw new RuntimeException("Автор з ID " + authorId + " не знайдений");
            }

            Optional<Category> category = categoryService.getCategoryById(categoryId);
            if (category.isEmpty()) {
                throw new RuntimeException("Категорія з ID " + categoryId + " не знайдена");
            }

            // Оновлюємо дані книги
            book.setTitle(title);
            book.setIsbn(isbn != null && !isbn.trim().isEmpty() ? isbn : null);
            book.setPublicationYear(publicationYear);
            book.setPages(pages);
            book.setAuthor(author.get());
            book.setCategory(category.get());
            book.setDescription(description != null && !description.trim().isEmpty() ? description : null);

            // Зберігаємо оновлену книгу
            bookService.updateBook(book);

            redirectAttributes.addFlashAttribute("successMessage", "Книгу \"" + title + "\" успішно оновлено");
            return "redirect:/books";

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Помилка при оновленні книги", e);

            // У випадку помилки повертаємося на форму з повідомленням
            try {
                Optional<Book> bookOpt = bookService.getBookById(id);
                List<Author> authors = authorService.getAllAuthors();
                List<Category> categories = categoryService.getAllCategories();

                model.addAttribute("book", bookOpt.orElse(new Book()));
                model.addAttribute("authors", authors != null ? authors : new ArrayList<>());
                model.addAttribute("categories", categories != null ? categories : new ArrayList<>());
            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Помилка при отриманні даних для форми редагування", ex);
            }

            model.addAttribute("errorMessage", "Помилка при оновленні книги: " + e.getMessage());
            return "book-edit";
        }
    }

    // Видалення книги
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            logger.info("Видалення книги з ID: " + id);

            // Перевіряємо, чи існує книга
            Optional<Book> bookOpt = bookService.getBookById(id);
            if (bookOpt.isEmpty()) {
                logger.warning("Книга з ID " + id + " не знайдена");
                redirectAttributes.addFlashAttribute("errorMessage", "Книга з ID " + id + " не знайдена");
                return "redirect:/books";
            }

            Book book = bookOpt.get();
            String bookTitle = book.getTitle();

            // Видаляємо книгу
            bookService.deleteBook(id);

            redirectAttributes.addFlashAttribute("successMessage", "Книгу \"" + bookTitle + "\" успішно видалено");
            return "redirect:/books";

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Помилка при видаленні книги", e);
            redirectAttributes.addFlashAttribute("errorMessage", "Помилка при видаленні книги: " + e.getMessage());
            return "redirect:/books";
        }
    }
}
