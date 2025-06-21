package gg.jte.generated.ondemand;
import gg.jte.Content;
@SuppressWarnings("unchecked")
public final class JtelayoutGenerated {
	public static final String JTE_NAME = "layout.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,1,9,9,9,9,79,79,79,84,84,84,1,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, gg.jte.Content content) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n<html lang=\"uk\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("</title>\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css\" rel=\"stylesheet\">\r\n    <style>\r\n        body {\r\n            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);\r\n            min-height: 100vh;\r\n            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\r\n        }\r\n        .main-container {\r\n            min-height: 100vh;\r\n            display: flex;\r\n            align-items: center;\r\n            justify-content: center;\r\n            padding: 20px;\r\n        }\r\n        .card {\r\n            backdrop-filter: blur(10px);\r\n            background: rgba(255, 255, 255, 0.95);\r\n            border: none;\r\n            border-radius: 20px;\r\n            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);\r\n        }\r\n        .navbar-brand {\r\n            font-weight: 600;\r\n            color: #fff !important;\r\n        }\r\n        .btn-primary {\r\n            background: linear-gradient(45deg, #667eea, #764ba2);\r\n            border: none;\r\n            border-radius: 10px;\r\n            padding: 12px 30px;\r\n            font-weight: 500;\r\n            transition: all 0.3s ease;\r\n        }\r\n        .btn-primary:hover {\r\n            transform: translateY(-2px);\r\n            box-shadow: 0 10px 20px rgba(102, 126, 234, 0.4);\r\n        }\r\n        .form-control {\r\n            border-radius: 10px;\r\n            border: 2px solid #e0e0e0;\r\n            padding: 12px 15px;\r\n            transition: all 0.3s ease;\r\n        }\r\n        .form-control:focus {\r\n            border-color: #667eea;\r\n            box-shadow: 0 0 0 0.2rem rgba(102, 126, 234, 0.25);\r\n        }\r\n        .alert {\r\n            border-radius: 10px;\r\n            border: none;\r\n        }\r\n    </style>\r\n</head>\r\n<body>\r\n<nav class=\"navbar navbar-expand-lg navbar-dark\" style=\"background: rgba(0,0,0,0.1);\">\r\n    <div class=\"container\">\r\n        <a class=\"navbar-brand\" href=\"/\">\r\n            <i class=\"fas fa-book me-2\"></i>\r\n            Library Management System\r\n        </a>\r\n        <div class=\"navbar-nav ms-auto\">\r\n            <a class=\"nav-link\" href=\"/\"><i class=\"fas fa-home me-1\"></i>Main</a>\r\n            <a class=\"nav-link\" href=\"/register\"><i class=\"fas fa-user-plus me-1\"></i>Registration</a>\r\n        </div>\r\n    </div>\r\n</nav>\r\n\r\n<div class=\"main-container\">\r\n    ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n</div>\r\n\r\n<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.getOrDefault("title", "Library Management System");
		gg.jte.Content content = (gg.jte.Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, title, content);
	}
}
