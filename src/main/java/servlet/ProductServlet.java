package servlet;

import entity.Category;
import entity.Product;
import service.CategoryService;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.process(req, resp);
    }

    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) {
            String id = req.getParameter("id");
            List<Product> products = ProductService.getInstance().getCategory(id);
            req.setAttribute("products", products);
            req.getRequestDispatcher("Products.jsp").forward(req, resp);
        }
        if(action.equals("assign")) {
            String id = req.getParameter("id");
            Product product = ProductService.getInstance().getProductById(id);
            List<Category> categories = CategoryService.getInstance().getCategory();
            req.setAttribute("product", product);
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("assign.jsp").forward(req, resp);
        }
        if(action.equals("update")) {
            String cateId = req.getParameter("cateId");
            String id = req.getParameter("idPr");
            Boolean flag = ProductService.getInstance().updateProduct(cateId, id);
            if(flag) {
                resp.sendRedirect("/ProductServlet?id=" + cateId);
            }
        }
    }

}
