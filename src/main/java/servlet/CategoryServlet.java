package servlet;

import entity.Category;
import service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/", urlPatterns = "")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        this.process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        this.process(req, resp);
    }

    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) {
            List<Category> categories = CategoryService.getInstance().getCategory();
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        if(action.equals("delete")) {
            String id = req.getParameter("id");
            Boolean flag = CategoryService.getInstance().deleteCategory(id);
        }
    }
}
