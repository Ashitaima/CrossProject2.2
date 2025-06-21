package gg.jte.generated.ondemand;
import ua.edu.chnu.springjpaproject.user.dto.UserRegistrationDto;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JteloginGenerated {
	public static final String JTE_NAME = "login.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,8,8,12,12,21,22,22,26,26,28,28,32,32,35,65,65,65,66,66,66,3,4,5,6,6,6,6};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Map<String, String> errors, String error, String logout, String currentUser) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Login", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n<div class=\"container mt-5\">\r\n    <div class=\"row justify-content-center\">\r\n        <div class=\"col-md-6\">\r\n            <div class=\"card\">\r\n                <div class=\"card-header\">\r\n                    <h3 class=\"text-center\">Login</h3>\r\n                </div>\r\n                <div class=\"card-body\">\r\n                    ");
				jteOutput.writeContent("\r\n                    ");
				if (error != null) {
					jteOutput.writeContent("\r\n                        <div class=\"alert alert-danger\">\r\n                            Invalid username or password.\r\n                        </div>\r\n                    ");
				}
				jteOutput.writeContent("\r\n\r\n                    ");
				if (logout != null) {
					jteOutput.writeContent("\r\n                        <div class=\"alert alert-success\">\r\n                            You have been logged out successfully.\r\n                        </div>\r\n                    ");
				}
				jteOutput.writeContent("\r\n\r\n                    <form action=\"/login\" method=\"post\">\r\n                        ");
				jteOutput.writeContent("\r\n\r\n                        <div class=\"mb-3\">\r\n                            <label for=\"username\" class=\"form-label\">Username</label>\r\n                            <input type=\"text\" id=\"username\" name=\"username\" class=\"form-control\" required autofocus>\r\n                        </div>\r\n\r\n                        <div class=\"mb-3\">\r\n                            <label for=\"password\" class=\"form-label\">Password</label>\r\n                            <input type=\"password\" id=\"password\" name=\"password\" class=\"form-control\" required>\r\n                        </div>\r\n\r\n                        <div class=\"mb-3 form-check\">\r\n                            <input type=\"checkbox\" class=\"form-check-input\" id=\"remember-me\" name=\"remember-me\">\r\n                            <label class=\"form-check-label\" for=\"remember-me\">Remember me</label>\r\n                        </div>\r\n\r\n                        <div class=\"d-grid gap-2\">\r\n                            <button type=\"submit\" class=\"btn btn-primary\">Login</button>\r\n                        </div>\r\n                    </form>\r\n\r\n                    <div class=\"mt-3 text-center\">\r\n                        <p>Don't have an account? <a href=\"/register\">Register</a></p>\r\n                    </div>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</div>\r\n");
			}
		}, currentUser);
		jteOutput.writeContent("\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Map<String, String> errors = (Map<String, String>)params.getOrDefault("errors", Map.of());
		String error = (String)params.getOrDefault("error", null);
		String logout = (String)params.getOrDefault("logout", null);
		String currentUser = (String)params.getOrDefault("currentUser", null);
		render(jteOutput, jteHtmlInterceptor, errors, error, logout, currentUser);
	}
}
