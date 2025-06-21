@param String title = "Main Page - Library Management System"

@template.layout(
title = title,
content = @`
    <div class="card" style="width: 100%; max-width: 800px;">
        <div class="card-body p-5">
            <div class="text-center mb-5">
                <i class="fas fa-book fa-4x text-primary mb-3"></i>
                <h1 class="card-title">Library Management System</h1>
            </div>

            <div class="row g-4">
                <div class="col-md-6">
                    <div class="card h-100 border-0" style="background: linear-gradient(45deg, #667eea, #764ba2); color: white;">
                        <div class="card-body text-center p-4">
                            <i class="fas fa-user-plus fa-3x mb-3"></i>
                            <h5 class="card-title">Registration</h5>
                            <p class="card-text">Create a new account for using LMS </p>
                            <a href="/register" class="btn btn-light btn-lg">
                                <i class="fas fa-user-plus me-2"></i>
                                Register
                            </a>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="card h-100 border-0" style="background: linear-gradient(45deg, #764ba2, #667eea); color: white;">
                        <div class="card-body text-center p-4">
                            <i class="fas fa-books fa-3x mb-3"></i>
                            <h5 class="card-title">Book</h5>
                            <p class="card-text">Browse and manage your library book collection</p>
                            <a href="/api/books" class="btn btn-light btn-lg">
                                <i class="fas fa-book me-2"></i>
                                Books API
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
                                This is a library management system training project developed using:
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

                            <div class="mt-4">
                                <h6>API Endpoints:</h6>
                                <div class="d-flex flex-wrap gap-2">
                                    <a href="/api/books" class="btn btn-outline-primary btn-sm">📚 Books API</a>
                                    <a href="/api/authors" class="btn btn-outline-success btn-sm">👤 Authors API</a>
                                    <a href="/api/categories" class="btn btn-outline-warning btn-sm">📂 Categories API</a>
                                    <a href="/index.html" class="btn btn-outline-info btn-sm">🧪 API Tester</a>
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