@import ua.edu.chnu.springjpaproject.user.UserRole
@param String errorMessage = null

@template.layout(content = @`
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">Реєстрація</div>
                    <div class="card-body">
                        @if(errorMessage != null)
                            <div class="alert alert-danger" role="alert">
                                ${errorMessage}
                            </div>
                        @endif
                        <form action="/register" method="post">
                            <div class="mb-3">
                                <label for="username" class="form-label">Ім'я користувача</label>
                                <input type="text" class="form-control" id="username" name="username" required minlength="3">
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Пароль</label>
                                <input type="password" class="form-control" id="password" name="password" required minlength="6">
                            </div>
                            <div class="mb-3">
                                <label for="role" class="form-label">Роль</label>
                                <select class="form-select" id="role" name="role">
                                    <option value="USER">Користувач</option>
                                    <option value="ADMIN">Адміністратор</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary">Зареєструватися</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
`)