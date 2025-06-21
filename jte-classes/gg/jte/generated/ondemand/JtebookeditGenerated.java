package gg.jte.generated.ondemand;
import ua.edu.chnu.springjpaproject.model.Book;
import ua.edu.chnu.springjpaproject.model.Author;
import ua.edu.chnu.springjpaproject.model.Category;
import java.util.List;
@SuppressWarnings("unchecked")
public final class JtebookeditGenerated {
	public static final String JTE_NAME = "book-edit.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,12,12,16,16,26,26,26,26,32,32,33,33,33,34,34,38,38,38,41,41,41,41,44,44,44,44,44,44,44,44,44,49,49,49,49,49,49,49,49,49,57,57,57,57,57,57,62,62,62,62,62,62,70,70,71,71,72,72,72,72,72,72,72,72,72,73,73,73,73,73,73,75,75,76,76,76,76,76,76,76,76,76,77,77,77,77,77,77,79,79,80,80,88,88,89,89,90,90,90,90,90,90,90,90,90,91,91,91,93,93,94,94,94,94,94,94,94,94,94,95,95,95,97,97,98,98,104,104,104,116,116,116,117,117,117,5,6,7,8,9,10,10,10,10};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, String currentUser, Book book, List<Author> authors, List<Category> categories, String errorMessage) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, title, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"container mt-4\">\r\n        <div class=\"row mb-4\">\r\n            <div class=\"col\">\r\n                <h1>Редагування книги</h1>\r\n            </div>\r\n            <div class=\"col-auto\">\r\n                <a href=\"/books\" class=\"btn btn-secondary\">\r\n                    <i class=\"fas fa-arrow-left\"></i> Повернутися до списку\r\n                </a>\r\n                <a href=\"/books/view/");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(book.getId());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\" class=\"btn btn-info\">\r\n                    <i class=\"fas fa-eye\"></i> Переглянути деталі\r\n                </a>\r\n            </div>\r\n        </div>\r\n\r\n        ");
				if (errorMessage != null) {
					jteOutput.writeContent("\r\n            <div class=\"alert alert-danger\">");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(errorMessage);
					jteOutput.writeContent("</div>\r\n        ");
				}
				jteOutput.writeContent("\r\n\r\n        <div class=\"card\">\r\n            <div class=\"card-header bg-warning text-dark\">\r\n                <h2>Редагування книги: ");
				jteOutput.setContext("h2", null);
				jteOutput.writeUserContent(book.getTitle());
				jteOutput.writeContent("</h2>\r\n            </div>\r\n            <div class=\"card-body\">\r\n                <form action=\"/books/edit/");
				jteOutput.setContext("form", "action");
				jteOutput.writeUserContent(book.getId());
				jteOutput.setContext("form", null);
				jteOutput.writeContent("\" method=\"post\">\r\n                    <div class=\"mb-3\">\r\n                        <label for=\"title\" class=\"form-label\">Назва книги*</label>\r\n                        <input type=\"text\" class=\"form-control\" id=\"title\" name=\"title\"");
				var __jte_html_attribute_0 = book.getTitle();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" required>\r\n                    </div>\r\n\r\n                    <div class=\"mb-3\">\r\n                        <label for=\"isbn\" class=\"form-label\">ISBN</label>\r\n                        <input type=\"text\" class=\"form-control\" id=\"isbn\" name=\"isbn\"");
				var __jte_html_attribute_1 = book.getIsbn() != null ? book.getIsbn() : "";
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\r\n                        <small class=\"text-muted\">Унікальний міжнародний номер книги</small>\r\n                    </div>\r\n\r\n                    <div class=\"row\">\r\n                        <div class=\"col-md-6 mb-3\">\r\n                            <label for=\"publicationYear\" class=\"form-label\">Рік публікації</label>\r\n                            <input type=\"number\" class=\"form-control\" id=\"publicationYear\" name=\"publicationYear\"\r\n                                   value=\"");
				if (book.getPublicationYear() != null) {
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(book.getPublicationYear());
					jteOutput.setContext("input", null);
				}
				jteOutput.writeContent("\" min=\"1800\" max=\"2099\">\r\n                        </div>\r\n                        <div class=\"col-md-6 mb-3\">\r\n                            <label for=\"pages\" class=\"form-label\">Кількість сторінок</label>\r\n                            <input type=\"number\" class=\"form-control\" id=\"pages\" name=\"pages\"\r\n                                   value=\"");
				if (book.getPages() != null) {
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(book.getPages());
					jteOutput.setContext("input", null);
				}
				jteOutput.writeContent("\" min=\"1\">\r\n                        </div>\r\n                    </div>\r\n\r\n                    <div class=\"mb-3\">\r\n                        <label for=\"author\" class=\"form-label\">Автор*</label>\r\n                        <select class=\"form-select\" id=\"author\" name=\"authorId\" required>\r\n                            <option value=\"\">Виберіть автора</option>\r\n                            ");
				for (Author author : authors) {
					jteOutput.writeContent("\r\n                                ");
					if (book.getAuthor() != null && book.getAuthor().getId().equals(author.getId())) {
						jteOutput.writeContent("\r\n                                    <option");
						var __jte_html_attribute_2 = author.getId();
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
							jteOutput.writeContent(" value=\"");
							jteOutput.setContext("option", "value");
							jteOutput.writeUserContent(__jte_html_attribute_2);
							jteOutput.setContext("option", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(" selected>\r\n                                        ");
						jteOutput.setContext("option", null);
						jteOutput.writeUserContent(author.getFirstName());
						jteOutput.writeContent(" ");
						jteOutput.setContext("option", null);
						jteOutput.writeUserContent(author.getLastName());
						jteOutput.writeContent("\r\n                                    </option>\r\n                                ");
					} else {
						jteOutput.writeContent("\r\n                                    <option");
						var __jte_html_attribute_3 = author.getId();
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
							jteOutput.writeContent(" value=\"");
							jteOutput.setContext("option", "value");
							jteOutput.writeUserContent(__jte_html_attribute_3);
							jteOutput.setContext("option", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">\r\n                                        ");
						jteOutput.setContext("option", null);
						jteOutput.writeUserContent(author.getFirstName());
						jteOutput.writeContent(" ");
						jteOutput.setContext("option", null);
						jteOutput.writeUserContent(author.getLastName());
						jteOutput.writeContent("\r\n                                    </option>\r\n                                ");
					}
					jteOutput.writeContent("\r\n                            ");
				}
				jteOutput.writeContent("\r\n                        </select>\r\n                    </div>\r\n\r\n                    <div class=\"mb-3\">\r\n                        <label for=\"category\" class=\"form-label\">Категорія*</label>\r\n                        <select class=\"form-select\" id=\"category\" name=\"categoryId\" required>\r\n                            <option value=\"\">Виберіть категорію</option>\r\n                            ");
				for (Category category : categories) {
					jteOutput.writeContent("\r\n                                ");
					if (book.getCategory() != null && book.getCategory().getId().equals(category.getId())) {
						jteOutput.writeContent("\r\n                                    <option");
						var __jte_html_attribute_4 = category.getId();
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
							jteOutput.writeContent(" value=\"");
							jteOutput.setContext("option", "value");
							jteOutput.writeUserContent(__jte_html_attribute_4);
							jteOutput.setContext("option", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(" selected>\r\n                                        ");
						jteOutput.setContext("option", null);
						jteOutput.writeUserContent(category.getName());
						jteOutput.writeContent("\r\n                                    </option>\r\n                                ");
					} else {
						jteOutput.writeContent("\r\n                                    <option");
						var __jte_html_attribute_5 = category.getId();
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_5)) {
							jteOutput.writeContent(" value=\"");
							jteOutput.setContext("option", "value");
							jteOutput.writeUserContent(__jte_html_attribute_5);
							jteOutput.setContext("option", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">\r\n                                        ");
						jteOutput.setContext("option", null);
						jteOutput.writeUserContent(category.getName());
						jteOutput.writeContent("\r\n                                    </option>\r\n                                ");
					}
					jteOutput.writeContent("\r\n                            ");
				}
				jteOutput.writeContent("\r\n                        </select>\r\n                    </div>\r\n\r\n                    <div class=\"mb-3\">\r\n                        <label for=\"description\" class=\"form-label\">Опис</label>\r\n                        <textarea class=\"form-control\" id=\"description\" name=\"description\" rows=\"4\">");
				jteOutput.setContext("textarea", null);
				jteOutput.writeUserContent(book.getDescription() != null ? book.getDescription() : "");
				jteOutput.writeContent("</textarea>\r\n                    </div>\r\n\r\n                    <div class=\"d-grid gap-2\">\r\n                        <button type=\"submit\" class=\"btn btn-warning\">\r\n                            <i class=\"fas fa-save\"></i> Зберегти зміни\r\n                        </button>\r\n                    </div>\r\n                </form>\r\n            </div>\r\n        </div>\r\n    </div>\r\n");
			}
		}, currentUser);
		jteOutput.writeContent("\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.getOrDefault("title", "Редагування книги");
		String currentUser = (String)params.getOrDefault("currentUser", null);
		Book book = (Book)params.get("book");
		List<Author> authors = (List<Author>)params.get("authors");
		List<Category> categories = (List<Category>)params.get("categories");
		String errorMessage = (String)params.getOrDefault("errorMessage", null);
		render(jteOutput, jteHtmlInterceptor, title, currentUser, book, authors, categories, errorMessage);
	}
}
