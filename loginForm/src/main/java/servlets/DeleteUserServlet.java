package servlets;

import controllers.Dao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        if(user.getRights().equals("administrator")) {
            new Dao().deleteUser(req.getParameter("user"));
            resp.sendRedirect("/rights");
        }else {
            resp.sendRedirect("/");
        }
    }
}
