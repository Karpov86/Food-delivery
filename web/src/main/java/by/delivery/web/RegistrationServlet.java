package by.delivery.web;

import by.delivery.entity.Address;
import by.delivery.entity.User;
import by.delivery.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.delivery.util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/register", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserServiceImpl userService = new UserServiceImpl();
        final boolean isSave = userService.save(new User.Builder()
                .setName(request.getParameter("name"))
                .setSurname(request.getParameter("surname"))
                .setHomeAddress(new Address(request.getParameter("city"), request.getParameter("street")))
                .setEmail(request.getParameter("email"))
                .setPhoneNumber(request.getParameter("phone number"))
                .setPassword(request.getParameter("password"))
                .build());
        if (isSave) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            response.sendRedirect(createViewPath("register"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher(createViewPath("register")).forward(request, response);
    }
}
