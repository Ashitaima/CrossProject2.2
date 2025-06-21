@import ua.edu.chnu.springjpaproject.user.dto.UserRegistrationDto
@import java.util.Map

@param Map<String, String> errors = Map.of()
@param String error = null
@param String logout = null

@template.layout(
title = "Вхід до системи",
content = @`
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h3 class="text-center">Вхід до системи</h3>
                </div>
                <div class="card-body">
                    <!-- Повідомлення про помилки -->
                    @if(error != null)
                        <div class="alert alert-danger">
                            Невірне ім'я користувача або пароль.
                        </div>
                    @endif

                    @if(logout != null)
                        <div class="alert alert-success">
                            Ви успішно вийшли з системи.
                        </div>
                    @endif

                    <form action="/login" method="post">
                        <!-- CSRF токен додається автоматично Spring Security -->

                        <div class="mb-3">
                            <label for="username" class="form-label">Ім'я користувача</label>
                            <input type="text" id="username" name="username" class="form-control" required autofocus>
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Пароль</label>
                            <input type="password" id="password" name="password" class="form-control" required>
                        </div>

                        <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" id="remember-me" name="remember-me">
                            <label class="form-check-label" for="remember-me">Запам'ятати мене</label>
                        </div>

                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-primary">Увійти</button>
                        </div>
                    </form>

                    <div class="mt-3 text-center">
                        <p>Немає облікового запису? <a href="/register">Зареєструватися</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
`
)
