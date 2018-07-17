package lostFound.servlet;

import lostFound.bean.Article;
import lostFound.dao.ArticleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
//新增物品servlet
@WebServlet("/FoundArticle")
public class FoundArticle extends HttpServlet {
    private ArticleDao articleDao = new ArticleDao();
    private Article article = new Article();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response){
        String articleDescription = request.getParameter("articleDescription");
        //String articleTime = request.getParameter("articleTime");
        String articleLocal = request.getParameter("articleLocal");
        String articleImage = "/img/article/kk.png";
        String articleContact = request.getParameter("articleContact");
        String articleAddress = request.getParameter("articleAddress");
        System.out.println(articleAddress+articleDescription);
        article.setArticleDescription(articleDescription);
        article.setArticleLocal(articleLocal);
        article.setArticleImage(articleImage);
        article.setArticleContact(articleContact);
        article.setArticleAddress(articleAddress);
        article.setArticleWebsite("1");

        try {
            articleDao.addArticle(article);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(articleTime);


    }

}


