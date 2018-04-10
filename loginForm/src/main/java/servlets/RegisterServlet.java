package servlets;

import controllers.Dao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/views/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();


        User user = new User();
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        user.setConfinrmPassword(req.getParameter("confirmPassword"));
        user.setEmail(req.getParameter("email"));
        user.setRights("user");

        if(!user.getPassword().equals(user.getConfinrmPassword())){
            session.setAttribute("showWarning", true);
            req.getRequestDispatcher("/views/register.jsp").forward(req,resp);
        }else {

            if (new Dao().addToDataBase(user)) {
                session.setAttribute("showRegistrationInfo", true);
                resp.sendRedirect("/login");
            } else {
                session.setAttribute("showUserConflictInfo", true);
                req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            }
        }



    }
}
