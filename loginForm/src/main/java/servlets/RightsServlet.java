package servlets;

import controllers.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rights")
class RightsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Dao db = new Dao();
        req.getSession().setAttribute("allUsers",db.getAllUsers());
        req.getRequestDispatcher("/views/rights.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new Dao().updatePrivileges(req.getParameter("userToChange"),req.getParameter("newRights"));
        doGet(req,resp);
    }
}
