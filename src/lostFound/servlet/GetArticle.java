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
import java.util.ArrayList;

@WebServlet("/GetArticle")
public class GetArticle extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");

        ArticleDao articleDao = new ArticleDao();
        ArrayList<Article> articleList = new ArrayList<Article>();

        articleList = articleDao.getArticle();
        String json = new Gson().toJson(articleList);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(json);
        printWriter.flush();
        printWriter.close();
    }
}
//测试json
/*String json1 = "[" +
        "{\"articleId\":\"" + 1 +
        "\",\"articleDescription\":\""+"一个黑色的钱包"+
        "\",\"articleLocal\":\""+"3区2栋604"+
        "\",\"articleImage\":\""+"/img/article/kk.png"+
        "\",\"articleContact\":\""+"18229738222"+
        "\",\"articleAddress\":\""+"某一个地方"+
        "\"},";
*/

