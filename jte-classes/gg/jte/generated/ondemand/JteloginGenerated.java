package gg.jte.generated.ondemand;
import ua.edu.chnu.springjpaproject.user.dto.UserRegistrationDto;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JteloginGenerated {
	public static final String JTE_NAME = "login.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,7,7,10,10,19,20,20,24,24,26,26,30,30,33,63,63,63,64,64,64,3,4,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Map<String, String> errors, String error, String logout) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Вхід до системи", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n<div class=\"container mt-5\">\r\n    <div class=\"row justify-content-center\">\r\n        <div class=\"col-md-6\">\r\n            <div class=\"card\">\r\n                <div class=\"card-header\">\r\n                    <h3 class=\"text-center\">Вхід до системи</h3>\r\n                </div>\r\n                <div class=\"card-body\">\r\n                    ");
				jteOutput.writeContent("\r\n                    ");
				if (error != null) {
					jteOutput.writeContent("\r\n                        <div class=\"alert alert-danger\">\r\n                            Невірне ім'я користувача або пароль.\r\n                        </div>\r\n                    ");
				}
				jteOutput.writeContent("\r\n\r\n                    ");
				if (logout != null) {
					jteOutput.writeContent("\r\n                        <div class=\"alert alert-success\">\r\n                            Ви успішно вийшли з системи.\r\n                        </div>\r\n                    ");
				}
				jteOutput.writeContent("\r\n\r\n                    <form action=\"/login\" method=\"post\">\r\n                        ");
				jteOutput.writeContent("\r\n\r\n                        <div class=\"mb-3\">\r\n                            <label for=\"username\" class=\"form-label\">Ім'я користувача</label>\r\n                            <input type=\"text\" id=\"username\" name=\"username\" class=\"form-control\" required autofocus>\r\n                        </div>\r\n\r\n                        <div class=\"mb-3\">\r\n                            <label for=\"password\" class=\"form-label\">Пароль</label>\r\n                            <input type=\"password\" id=\"password\" name=\"password\" class=\"form-control\" required>\r\n                        </div>\r\n\r\n                        <div class=\"mb-3 form-check\">\r\n                            <input type=\"checkbox\" class=\"form-check-input\" id=\"remember-me\" name=\"remember-me\">\r\n                            <label class=\"form-check-label\" for=\"remember-me\">Запам'ятати мене</label>\r\n                        </div>\r\n\r\n                        <div class=\"d-grid gap-2\">\r\n                            <button type=\"submit\" class=\"btn btn-primary\">Увійти</button>\r\n                        </div>\r\n                    </form>\r\n\r\n                    <div class=\"mt-3 text-center\">\r\n                        <p>Немає облікового запису? <a href=\"/register\">Зареєструватися</a></p>\r\n                    </div>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</div>\r\n");
			}
		});
		jteOutput.writeContent("\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Map<String, String> errors = (Map<String, String>)params.getOrDefault("errors", Map.of());
		String error = (String)params.getOrDefault("error", null);
		String logout = (String)params.getOrDefault("logout", null);
		render(jteOutput, jteHtmlInterceptor, errors, error, logout);
	}
}
