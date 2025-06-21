@import ua.edu.chnu.springjpaproject.model.Book
@import ua.edu.chnu.springjpaproject.model.Author
@import ua.edu.chnu.springjpaproject.model.Category
@import java.util.List

@param String title = "Редагування книги"
@param String currentUser = null
@param Book book
@param List<Author> authors
@param List<Category> categories
@param String errorMessage = null

@template.layout(
title = title,
currentUser = currentUser,
content = @`
    <div class="container mt-4">
        <div class="row mb-4">
            <div class="col">
                <h1>Редагування книги</h1>
            </div>
            <div class="col-auto">
                <a href="/books" class="btn btn-secondary">
                    <i class="fas fa-arrow-left"></i> Повернутися до списку
                </a>
                <a href="/books/view/${book.getId()}" class="btn btn-info">
                    <i class="fas fa-eye"></i> Переглянути деталі
                </a>
            </div>
        </div>

        @if(errorMessage != null)
            <div class="alert alert-danger">${errorMessage}</div>
        @endif

        <div class="card">
            <div class="card-header bg-warning text-dark">
                <h2>Редагування книги: ${book.getTitle()}</h2>
            </div>
            <div class="card-body">
                <form action="/books/edit/${book.getId()}" method="post">
                    <div class="mb-3">
                        <label for="title" class="form-label">Назва книги*</label>
                        <input type="text" class="form-control" id="title" name="title" value="${book.getTitle()}" required>
                    </div>

                    <div class="mb-3">
                        <label for="isbn" class="form-label">ISBN</label>
                        <input type="text" class="form-control" id="isbn" name="isbn" value="${book.getIsbn() != null ? book.getIsbn() : ""}">
                        <small class="text-muted">Унікальний міжнародний номер книги</small>
                    </div>

                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="publicationYear" class="form-label">Рік публікації</label>
                            <input type="number" class="form-control" id="publicationYear" name="publicationYear"
                                   value="@if(book.getPublicationYear() != null)${book.getPublicationYear()}@endif" min="1800" max="2099">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="pages" class="form-label">Кількість сторінок</label>
                            <input type="number" class="form-control" id="pages" name="pages"
                                   value="@if(book.getPages() != null)${book.getPages()}@endif" min="1">
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="author" class="form-label">Автор*</label>
                        <select class="form-select" id="author" name="authorId" required>
                            <option value="">Виберіть автора</option>
                            @for(Author author : authors)
                                @if(book.getAuthor() != null && book.getAuthor().getId().equals(author.getId()))
                                    <option value="${author.getId()}" selected>
                                        ${author.getFirstName()} ${author.getLastName()}
                                    </option>
                                @else
                                    <option value="${author.getId()}">
                                        ${author.getFirstName()} ${author.getLastName()}
                                    </option>
                                @endif
                            @endfor
                        </select>
                    </div>

                    <div class="mb-3">
                        <label for="category" class="form-label">Категорія*</label>
                        <select class="form-select" id="category" name="categoryId" required>
                            <option value="">Виберіть категорію</option>
                            @for(Category category : categories)
                                @if(book.getCategory() != null && book.getCategory().getId().equals(category.getId()))
                                    <option value="${category.getId()}" selected>
                                        ${category.getName()}
                                    </option>
                                @else
                                    <option value="${category.getId()}">
                                        ${category.getName()}
                                    </option>
                                @endif
                            @endfor
                        </select>
                    </div>

                    <div class="mb-3">
                        <label for="description" class="form-label">Опис</label>
                        <textarea class="form-control" id="description" name="description" rows="4">${book.getDescription() != null ? book.getDescription() : ""}</textarea>
                    </div>

                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-warning">
                            <i class="fas fa-save"></i> Зберегти зміни
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
`
)
