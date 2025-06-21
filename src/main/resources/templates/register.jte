@import ua.edu.chnu.springjpaproject.user.dto.UserRegistrationDto
@param UserRegistrationDto user = null
@param java.util.Map<String, String> errors = null
@param String successMessage = null

@template.layout(
title = "Реєстрація користувача",
content = @`
    <div class="card" style="width: 100%; max-width: 500px;">
        <div class="card-body p-5">
            <div class="text-center mb-4">
                <i class="fas fa-user-plus fa-3x text-primary mb-3"></i>
                <h2 class="card-title">Реєстрація</h2>
                <p class="text-muted">Створіть новий обліковий запис</p>
            </div>

            @if(successMessage != null)
                <div class="alert alert-success" role="alert">
                    <i class="fas fa-check-circle me-2"></i>
                    ${successMessage}
                </div>
            @endif

            @if(errors != null && !errors.isEmpty())
                <div class="alert alert-danger" role="alert">
                    <i class="fas fa-exclamation-triangle me-2"></i>
                    <strong>Помилки валідації:</strong>
                    <ul class="mb-0 mt-2">
                        @for(String error : errors.values())
                            <li>${error}</li>
                        @endfor
                    </ul>
                </div>
            @endif

            <form method="post" action="/api/users/register" id="registrationForm">
                <div class="mb-3">
                    <label for="username" class="form-label">
                        <i class="fas fa-user me-2"></i>Ім'я користувача
                    </label>
                    <input
                            type="text"
                            class="form-control @if(errors != null && errors.containsKey("username"))is-invalid@endif"
                            id="username"
                            name="username"
                            value="@if(user != null && user.getUsername() != null)${user.getUsername()}@endif"
                            placeholder="Введіть ім'я користувача"
                            required
                    >
                    @if(errors != null && errors.containsKey("username"))
                        <div class="invalid-feedback">
                            ${errors.get("username")}
                        </div>
                    @endif
                </div>

                <div class="mb-3">
                    <label for="password" class="form-label">
                        <i class="fas fa-lock me-2"></i>Пароль
                    </label>
                    <input
                            type="password"
                            class="form-control @if(errors != null && errors.containsKey("password"))is-invalid@endif"
                            id="password"
                            name="password"
                            placeholder="Введіть пароль"
                            required
                    >
                    @if(errors != null && errors.containsKey("password"))
                        <div class="invalid-feedback">
                            ${errors.get("password")}
                        </div>
                    @endif
                    <div class="form-text">
                        <i class="fas fa-info-circle me-1"></i>
                        Пароль повинен містити мінімум 6 символів
                    </div>
                </div>

                <div class="mb-4">
                    <label for="confirmPassword" class="form-label">
                        <i class="fas fa-lock me-2"></i>Підтвердження паролю
                    </label>
                    <input
                            type="password"
                            class="form-control @if(errors != null && errors.containsKey("confirmPassword"))is-invalid@endif"
                            id="confirmPassword"
                            name="confirmPassword"
                            placeholder="Підтвердіть пароль"
                            required
                    >
                    @if(errors != null && errors.containsKey("confirmPassword"))
                        <div class="invalid-feedback">
                            ${errors.get("confirmPassword")}
                        </div>
                    @endif
                </div>

                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-primary btn-lg">
                        <i class="fas fa-user-plus me-2"></i>
                        Зареєструватися
                    </button>
                </div>
            </form>

            <div class="text-center mt-4">
                <p class="text-muted">
                    Вже маєте обліковий запис?
                    <a href="/login" class="text-decoration-none">Увійти</a>
                </p>
            </div>
        </div>
    </div>

    <script>
        // Клієнтська валідація
        document.getElementById('registrationForm').addEventListener('submit', function(e) {
            const password = document.getElementById('password').value;
            const confirmPassword = document.getElementById('confirmPassword').value;

            if (password !== confirmPassword) {
                e.preventDefault();
                alert('Паролі не співпадають!');
                return false;
            }

            if (password.length < 6) {
                e.preventDefault();
                alert('Пароль повинен містити мінімум 6 символів!');
                return false;
            }
        });
    </script>
`
)