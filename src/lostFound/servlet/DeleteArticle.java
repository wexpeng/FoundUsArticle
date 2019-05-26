package lostFound.servlet;

import lostFound.bean.Article;
import lostFound.dao.ArticleDao;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@MultipartConfig
@WebServlet("/DeleteArticle")
public class DeleteArticle extends HttpServlet {
    private ArticleDao articleDao = new ArticleDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        articleDao.delArticle(req.getParameter("id"));
        resp.sendRedirect("manage/index.jsp");
    }
}
