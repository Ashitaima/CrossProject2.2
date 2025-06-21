package gg.jte.generated.ondemand;
import ua.edu.chnu.springjpaproject.user.dto.UserRegistrationDto;
@SuppressWarnings("unchecked")
public final class JteregisterGenerated {
	public static final String JTE_NAME = "register.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,1,5,5,8,8,17,17,20,20,20,22,22,24,24,29,29,30,30,30,31,31,34,34,43,43,43,43,46,46,46,46,46,46,50,50,52,52,52,54,54,63,63,63,63,69,69,71,71,71,73,73,86,86,86,86,92,92,94,94,94,96,96,117,135,135,135,135,135,1,2,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UserRegistrationDto user, java.util.Map<String, String> errors, String successMessage) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Registration - Library Management System", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"card\" style=\"width: 100%; max-width: 500px;\">\r\n        <div class=\"card-body p-5\">\r\n            <div class=\"text-center mb-4\">\r\n                <i class=\"fas fa-user-plus fa-3x text-primary mb-3\"></i>\r\n                <h2 class=\"card-title\">Registration</h2>\r\n                <p class=\"text-muted\">Create new account</p>\r\n            </div>\r\n\r\n            ");
				if (successMessage != null) {
					jteOutput.writeContent("\r\n                <div class=\"alert alert-success\" role=\"alert\">\r\n                    <i class=\"fas fa-check-circle me-2\"></i>\r\n                    ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(successMessage);
					jteOutput.writeContent("\r\n                </div>\r\n            ");
				}
				jteOutput.writeContent("\r\n\r\n            ");
				if (errors != null && !errors.isEmpty()) {
					jteOutput.writeContent("\r\n                <div class=\"alert alert-danger\" role=\"alert\">\r\n                    <i class=\"fas fa-exclamation-triangle me-2\"></i>\r\n                    <strong>Validation error:</strong>\r\n                    <ul class=\"mb-0 mt-2\">\r\n                        ");
					for (String error : errors.values()) {
						jteOutput.writeContent("\r\n                            <li>");
						jteOutput.setContext("li", null);
						jteOutput.writeUserContent(error);
						jteOutput.writeContent("</li>\r\n                        ");
					}
					jteOutput.writeContent("\r\n                    </ul>\r\n                </div>\r\n            ");
				}
				jteOutput.writeContent("\r\n\r\n            <form method=\"post\" action=\"/api/users/register\" id=\"registrationForm\">\r\n                <div class=\"mb-3\">\r\n                    <label for=\"username\" class=\"form-label\">\r\n                        <i class=\"fas fa-user me-2\"></i>Username\r\n                    </label>\r\n                    <input\r\n                            type=\"text\"\r\n                            class=\"form-control ");
				if (errors != null && errors.containsKey("username")) {
					jteOutput.writeContent("is-invalid");
				}
				jteOutput.writeContent("\"\r\n                            id=\"username\"\r\n                            name=\"username\"\r\n                            value=\"");
				if (user != null && user.getUsername() != null) {
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(user.getUsername());
					jteOutput.setContext("input", null);
				}
				jteOutput.writeContent("\"\r\n                            placeholder=\"Enter your username\"\r\n                            required\r\n                    >\r\n                    ");
				if (errors != null && errors.containsKey("username")) {
					jteOutput.writeContent("\r\n                        <div class=\"invalid-feedback\">\r\n                            ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(errors.get("username"));
					jteOutput.writeContent("\r\n                        </div>\r\n                    ");
				}
				jteOutput.writeContent("\r\n                </div>\r\n\r\n                <div class=\"mb-3\">\r\n                    <label for=\"password\" class=\"form-label\">\r\n                        <i class=\"fas fa-lock me-2\"></i>Password\r\n                    </label>\r\n                    <input\r\n                            type=\"password\"\r\n                            class=\"form-control ");
				if (errors != null && errors.containsKey("password")) {
					jteOutput.writeContent("is-invalid");
				}
				jteOutput.writeContent("\"\r\n                            id=\"password\"\r\n                            name=\"password\"\r\n                            placeholder=\"Enter your password\"\r\n                            required\r\n                    >\r\n                    ");
				if (errors != null && errors.containsKey("password")) {
					jteOutput.writeContent("\r\n                        <div class=\"invalid-feedback\">\r\n                            ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(errors.get("password"));
					jteOutput.writeContent("\r\n                        </div>\r\n                    ");
				}
				jteOutput.writeContent("\r\n                    <div class=\"form-text\">\r\n                        <i class=\"fas fa-info-circle me-1\"></i>\r\n                        The password must contain at least 6 characters.\r\n                    </div>\r\n                </div>\r\n\r\n                <div class=\"mb-4\">\r\n                    <label for=\"confirmPassword\" class=\"form-label\">\r\n                        <i class=\"fas fa-lock me-2\"></i>Password confirmation\r\n                    </label>\r\n                    <input\r\n                            type=\"password\"\r\n                            class=\"form-control ");
				if (errors != null && errors.containsKey("confirmPassword")) {
					jteOutput.writeContent("is-invalid");
				}
				jteOutput.writeContent("\"\r\n                            id=\"confirmPassword\"\r\n                            name=\"confirmPassword\"\r\n                            placeholder=\"Confirm your password\"\r\n                            required\r\n                    >\r\n                    ");
				if (errors != null && errors.containsKey("confirmPassword")) {
					jteOutput.writeContent("\r\n                        <div class=\"invalid-feedback\">\r\n                            ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(errors.get("confirmPassword"));
					jteOutput.writeContent("\r\n                        </div>\r\n                    ");
				}
				jteOutput.writeContent("\r\n                </div>\r\n\r\n                <div class=\"d-grid gap-2\">\r\n                    <button type=\"submit\" class=\"btn btn-primary btn-lg\">\r\n                        <i class=\"fas fa-user-plus me-2\"></i>\r\n                        Register\r\n                    </button>\r\n                </div>\r\n            </form>\r\n\r\n            <div class=\"text-center mt-4\">\r\n                <p class=\"text-muted\">\r\n                    Already have an account?\r\n                    <a href=\"/login\" class=\"text-decoration-none\">Login</a>\r\n                </p>\r\n            </div>\r\n        </div>\r\n    </div>\r\n\r\n    <script>\r\n        ");
				jteOutput.writeContent("\n        document.getElementById('registrationForm').addEventListener('submit', function(e) {\r\n            const password = document.getElementById('password').value;\r\n            const confirmPassword = document.getElementById('confirmPassword').value;\r\n\r\n            if (password !== confirmPassword) {\r\n                e.preventDefault();\r\n                alert('Passwords do not match!');\r\n                return false;\r\n            }\r\n\r\n            if (password.length < 6) {\r\n                e.preventDefault();\r\n                alert('The password must contain at least 6 characters!');\r\n                return false;\r\n            }\r\n        });\r\n    </script>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UserRegistrationDto user = (UserRegistrationDto)params.getOrDefault("user", null);
		java.util.Map<String, String> errors = (java.util.Map<String, String>)params.getOrDefault("errors", null);
		String successMessage = (String)params.getOrDefault("successMessage", null);
		render(jteOutput, jteHtmlInterceptor, user, errors, successMessage);
	}
}
