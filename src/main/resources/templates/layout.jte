@import gg.jte.Content
@param String title = "Library Management System"
@param gg.jte.Content content
@param String currentUser = null

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .main-container {
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }
        .card {
            backdrop-filter: blur(10px);
            background: rgba(255, 255, 255, 0.95);
            border: none;
            border-radius: 20px;
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
        }
        .navbar-brand {
            font-weight: 600;
            color: #fff !important;
        }
        .btn-primary {
            background: linear-gradient(45deg, #667eea, #764ba2);
            border: none;
            border-radius: 10px;
            padding: 12px 30px;
            font-weight: 500;
            transition: all 0.3s ease;
        }
        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0 10px 20px rgba(102, 126, 234, 0.4);
        }
        .form-control {
            border-radius: 10px;
            border: 2px solid #e0e0e0;
            padding: 12px 15px;
            transition: all 0.3s ease;
        }
        .form-control:focus {
            border-color: #667eea;
            box-shadow: 0 0 0 0.2rem rgba(102, 126, 234, 0.25);
        }
        .alert {
            border-radius: 10px;
            border: none;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark" style="background: linear-gradient(45deg, #667eea, #764ba2);">
        <div class="container">
            <a class="navbar-brand" href="/">
                <i class="fas fa-book-open me-2"></i>Library System
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/"><i class="fas fa-home me-1"></i>Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/books"><i class="fas fa-book me-1"></i>Books</a>
                    </li>
                </ul>
                <div class="d-flex">
                    @if(currentUser != null)
                        <span class="navbar-text me-3">
                            <i class="fas fa-user me-1"></i>${currentUser}
                        </span>
                        <form action="/logout" method="post" class="d-inline">
                            <button type="submit" class="btn btn-outline-light btn-sm">
                                <i class="fas fa-sign-out-alt me-1"></i>Logout
                            </button>
                        </form>
                    @else
                        <a href="/login" class="btn btn-outline-light btn-sm me-2">
                            <i class="fas fa-sign-in-alt me-1"></i>Login
                        </a>
                        <a href="/register" class="btn btn-light btn-sm">
                            <i class="fas fa-user-plus me-1"></i>Register
                        </a>
                    @endif
                </div>
            </div>
        </div>
    </nav>

    <div class="main-container">
        ${content}
    </div>

    <footer class="text-center text-white py-3 mt-5" style="background: rgba(0, 0, 0, 0.2);">
        <div class="container">
            <p class="mb-0">© 2025 Library Management System</p>
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>