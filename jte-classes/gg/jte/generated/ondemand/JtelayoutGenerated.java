package gg.jte.generated.ondemand;
import gg.jte.Content;
@SuppressWarnings("unchecked")
public final class JtelayoutGenerated {
	public static final String JTE_NAME = "layout.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,1,9,9,9,9,79,79,79,84,84,84,1,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, gg.jte.Content content) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"uk\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("</title>\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css\" rel=\"stylesheet\">\n    <style>\n        body {\n            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);\n            min-height: 100vh;\n            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n        }\n        .main-container {\n            min-height: 100vh;\n            display: flex;\n            align-items: center;\n            justify-content: center;\n            padding: 20px;\n        }\n        .card {\n            backdrop-filter: blur(10px);\n            background: rgba(255, 255, 255, 0.95);\n            border: none;\n            border-radius: 20px;\n            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);\n        }\n        .navbar-brand {\n            font-weight: 600;\n            color: #fff !important;\n        }\n        .btn-primary {\n            background: linear-gradient(45deg, #667eea, #764ba2);\n            border: none;\n            border-radius: 10px;\n            padding: 12px 30px;\n            font-weight: 500;\n            transition: all 0.3s ease;\n        }\n        .btn-primary:hover {\n            transform: translateY(-2px);\n            box-shadow: 0 10px 20px rgba(102, 126, 234, 0.4);\n        }\n        .form-control {\n            border-radius: 10px;\n            border: 2px solid #e0e0e0;\n            padding: 12px 15px;\n            transition: all 0.3s ease;\n        }\n        .form-control:focus {\n            border-color: #667eea;\n            box-shadow: 0 0 0 0.2rem rgba(102, 126, 234, 0.25);\n        }\n        .alert {\n            border-radius: 10px;\n            border: none;\n        }\n    </style>\n</head>\n<body>\n<nav class=\"navbar navbar-expand-lg navbar-dark\" style=\"background: rgba(0,0,0,0.1);\">\n    <div class=\"container\">\n        <a class=\"navbar-brand\" href=\"/\">\n            <i class=\"fas fa-book me-2\"></i>\n            Library Management System\n        </a>\n        <div class=\"navbar-nav ms-auto\">\n            <a class=\"nav-link\" href=\"/\"><i class=\"fas fa-home me-1\"></i>Main</a>\n            <a class=\"nav-link\" href=\"/register\"><i class=\"fas fa-user-plus me-1\"></i>Registration</a>\n        </div>\n    </div>\n</nav>\n\n<div class=\"main-container\">\n    ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n</div>\n\n<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.getOrDefault("title", "Library Management System");
		gg.jte.Content content = (gg.jte.Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, title, content);
	}
}
