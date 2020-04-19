package by.delivery.web;

import by.delivery.AuthenticationUserService;
import by.delivery.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static by.delivery.util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/login", name = "ServletUtil")
public class LoginServlet extends HttpServlet {

    private static final Map<String, Locale> LOCALES = new HashMap<>();

    static {
        LOCALES.put("ru", new Locale("ru", "RU"));
        LOCALES.put("en", new Locale("en", "EN"));
    }

    public static Locale getLocale(String str) {
        if (LOCALES.containsKey(str)) {
            return LOCALES.get(str);
        } else {
            return Locale.getDefault();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (new AuthenticationUserService().authentication(name, password)) {
            request.getSession().setAttribute("currentUser", new User.Builder().setName(name).setPassword(password).build());
            response.sendRedirect("/");
        } else {
            response.sendRedirect("/login");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String str = request.getParameter("language");
        request.setAttribute("language", getLocale(str));

        getServletContext()
                .getRequestDispatcher(createViewPath("login"))
                .forward(request, response);
    }
}
