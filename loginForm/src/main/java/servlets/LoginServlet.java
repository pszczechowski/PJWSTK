package servlets;

import controllers.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Dao db = new Dao();

        if(db.isUserCorrectAuth(req.getParameter("login"),req.getParameter("password"))){
            session.setAttribute("zalogowany",true);
            session.setAttribute("user",db.getUserByName(req.getParameter("login")));
            resp.sendRedirect("/index");
        }else{
            session.setAttribute("showAuthError",true);
            req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
        }
    }
}
