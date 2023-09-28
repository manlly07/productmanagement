package servlet;

import entity.Infomation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "InformationServlet", urlPatterns = "/InformationServlet")
public class InformationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("information.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        if(firstname.equals("") || lastname.equals("") || password.equals("") || repassword.equals("")) {
            req.setAttribute("errMsg", "All field are required !");
            req.getRequestDispatcher("information.jsp").forward(req, resp);
            return;
        }
        if (!repassword.equals(password)) {
            req.setAttribute("errMsg", "Two password must be same!");
            req.getRequestDispatcher("information.jsp").forward(req, resp);
            return;
        }
        Cookie first = new Cookie("firstname", firstname);
        Cookie last = new Cookie("lastname", lastname);
        first.setMaxAge(1800);
        last.setMaxAge(1800);
        resp.addCookie(first);
        resp.addCookie(last);
        req.getRequestDispatcher("display.jsp").forward(req, resp);
    }
}
