package lostFound.servlet;

import com.google.gson.Gson;
import lostFound.bean.Article;
import lostFound.dao.ArticleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/SearchArticle")
public class SearchArticle extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Article article = new Article();
        ArticleDao articleDao = new ArticleDao();
        PrintWriter printWriter = resp.getWriter();

        ArrayList<Article> articleList = new ArrayList<Article>();

        String searchKey = req.getParameter("searchKey");

        if (searchKey == null){
            searchKey = "校";
        }

        articleList = articleDao.getArticle(searchKey);
        String json = new Gson().toJson(articleList);
        printWriter.print(json);
        System.out.print("测试"+json);
        printWriter.print("<script>$('#splitlayout').attr(\"class\",\"splitlayout open-left\");<script>");
        printWriter.flush();
        printWriter.close();


    }
}
