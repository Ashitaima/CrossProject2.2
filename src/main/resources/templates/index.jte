@param String title = "Головна сторінка"
@param gg.jte.Content content
@template.layout(
title = title,
content = @`
    <div class="card" style="width: 100%; max-width: 800px;">
        <div class="card-body p-5">
            <div class="text-center mb-5">
                <i class="fas fa-book fa-4x text-primary mb-3"></i>
                <h1 class="card-title">Library Management System</h1>
                <p class="lead text-muted">Система управління бібліотекою</p>
            </div>

            <div class="row g-4">
                <div class="col-md-6">
                    <div class="card h-100 border-0" style="background: linear-gradient(45deg, #667eea, #764ba2); color: white;">
                        <div class="card-body text-center p-4">
                            <i class="fas fa-user-plus fa-3x mb-3"></i>
                            <h5 class="card-title">Реєстрація</h5>
                            <p class="card-text">Створіть новий обліковий запис для роботи з системою</p>
                            <a href="/register" class="btn btn-light btn-lg">
                                <i class="fas fa-user-plus me-2"></i>
                                Зареєструватися
                            </a>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="card h-100 border-0" style="background: linear-gradient(45deg, #764ba2, #667eea); color: white;">
                        <div class="card-body text-center p-4">
                            <i class="fas fa-books fa-3x mb-3"></i>
                            <h5 class="card-title">Книги</h5>
                            <p class="card-text">Переглядайте та керуйте колекцією книг бібліотеки</p>
                            <a href="/books" class="btn btn-light btn-lg">
                                <i class="fas fa-book me-2"></i>
                                Переглянути книги
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-12">
                    <div class="card border-0" style="background: rgba(102, 126, 234, 0.1);">
                        <div class="card-body p-4">
                            <h5 class="card-title">
                                <i class="fas fa-info-circle me-2"></i>
                                Про систему
                            </h5>
                            <p class="card-text">
                                Це навчальний проект системи управління бібліотекою, розроблений з використанням:
                            </p>
                            <div class="row">
                                <div class="col-md-6">
                                    <ul class="list-unstyled">
                                        <li><i class="fas fa-check text-success me-2"></i>Spring Boot 3</li>
                                        <li><i class="fas fa-check text-success me-2"></i>Spring Data JPA</li>
                                        <li><i class="fas fa-check text-success me-2"></i>PostgreSQL</li>
                                    </ul>
                                </div>
                                <div class="col-md-6">
                                    <ul class="list-unstyled">
                                        <li><i class="fas fa-check text-success me-2"></i>JTE Templates</li>
                                        <li><i class="fas fa-check text-success me-2"></i>Flyway Migrations</li>
                                        <li><i class="fas fa-check text-success me-2"></i>BCrypt Security</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
`
)