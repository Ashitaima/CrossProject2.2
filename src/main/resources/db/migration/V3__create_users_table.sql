-- Створення таблиці користувачів
CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL DEFAULT 'USER',
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Індекс для швидкого пошуку по username
CREATE INDEX idx_users_username ON users(username);

-- Коментарі до полів
COMMENT ON TABLE users IS 'Таблиця користувачів системи';
COMMENT ON COLUMN users.id IS 'Унікальний ідентифікатор користувача';
COMMENT ON COLUMN users.username IS 'Ім''я користувача (логін)';
COMMENT ON COLUMN users.password IS 'Хешований пароль користувача';
COMMENT ON COLUMN users.role IS 'Роль користувача (USER, ADMIN)';
COMMENT ON COLUMN users.created_at IS 'Дата та час створення запису';
COMMENT ON COLUMN users.updated_at IS 'Дата та час останнього оновлення';