@import ua.edu.chnu.springjpaproject.model.Book
@param String title = "Деталі книги"
@param String currentUser = null
@param Book book
@param String errorMessage = null

@template.layout(
title = title,
currentUser = currentUser,
content = @`
    <div class="container mt-4">
        <div class="row mb-4">
            <div class="col">
                <h1>Деталі книги</h1>
            </div>
            <div class="col-auto">
                <a href="/books" class="btn btn-secondary">
                    <i class="fas fa-arrow-left"></i> Повернутися до списку
                </a>
                <a href="/books/edit/${book.getId()}" class="btn btn-warning">
                    <i class="fas fa-edit"></i> Редагувати
                </a>
            </div>
        </div>

        @if(errorMessage != null)
            <div class="alert alert-danger">${errorMessage}</div>
        @endif

        <div class="card">
            <div class="card-header bg-primary text-white">
                <h2>${book.getTitle()}</h2>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-md-8">
                        <table class="table">
                            <tr>
                                <th style="width: 150px;">ID:</th>
                                <td>${book.getId()}</td>
                            </tr>
                            <tr>
                                <th>Автор:</th>
                                <td>
                                    @if(book.getAuthor() != null)
                                        ${book.getAuthor().getFirstName()} ${book.getAuthor().getLastName()}
                                    @else
                                        Не вказано
                                    @endif
                                </td>
                            </tr>
                            <tr>
                                <th>Категорія:</th>
                                <td>
                                    @if(book.getCategory() != null)
                                        ${book.getCategory().getName()}
                                    @else
                                        Не вказано
                                    @endif
                                </td>
                            </tr>
                            <tr>
                                <th>Рік публікації:</th>
                                <td>
                                    @if(book.getPublicationYear() != null)
                                        ${book.getPublicationYear()}
                                    @else
                                        Не вказано
                                    @endif
                                </td>
                            </tr>
                            <tr>
                                <th>ISBN:</th>
                                <td>${book.getIsbn() != null ? book.getIsbn() : "Не вказано"}</td>
                            </tr>
                            <tr>
                                <th>Кількість сторінок:</th>
                                <td>
                                    @if(book.getPages() != null)
                                        ${book.getPages()}
                                    @else
                                        Не вказано
                                    @endif
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-3">
                            <div class="card-header">Інформація</div>
                            <div class="card-body">
                                <p><strong>Дата створення:</strong>
                                    @if(book.getCreatedAt() != null)
                                        ${book.getCreatedAt().toLocalDate().toString()}
                                    @else
                                        Не вказано
                                    @endif
                                </p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card mt-3">
                    <div class="card-header">Опис</div>
                    <div class="card-body">
                        @if(book.getDescription() != null && !book.getDescription().isEmpty())
                            <p>${book.getDescription()}</p>
                        @else
                            <p class="text-muted">Опис відсутній</p>
                        @endif
                    </div>
                </div>
            </div>
            <div class="card-footer">
                <form action="/books/delete/${book.getId()}" method="post" style="display:inline;"
                      onsubmit="return confirm('Ви впевнені, що хочете видалити цю книгу?')">
                    <button type="submit" class="btn btn-danger">
                        <i class="fas fa-trash"></i> Видалити книгу
                    </button>
                </form>
            </div>
        </div>
    </div>
`
)
