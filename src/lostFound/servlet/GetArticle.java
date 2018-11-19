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
    ArticleDao articleDao = new ArticleDao();
    Article article = new Article();

    ArrayList<Article> articleArrayList = new ArrayList<Article>();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");


        articleArrayList = articleDao.getAllArticle();
        String json = new Gson().toJson(articleArrayList);

        //String json1 = "[" +
        //        "{\"articleId\":\"" + 1 +
        //        "\",\"articleDescription\":\""+"一个黑色的钱包"+
        //        "\",\"articleLocal\":\""+"3区2栋604"+
        //        "\",\"articleImage\":\""+"/img/article/kk.png"+
        //        "\",\"articleContact\":\""+"18229738222"+
        //        "\",\"articleAddress\":\""+"牛耳实训基地"+
        //        "\"},";
        //
        //String json2 =
        //        "{\"articleId\":\"" + 1 +
        //        "\",\"articleDescription\":\""+"一个黑色的钱包"+
        //        "\",\"articleLocal\":\""+"3区2栋604"+
        //        "\",\"articleImage\":\""+"/img/article/kk.png"+
        //        "\",\"articleContact\":\""+"18229738222"+
        //        "\",\"articleAddress\":\""+"牛耳实训基地"+
        //        "\"},";
        //
        //String json3 =
        //        "{\"articleId\":\"" + 1 +
        //        "\",\"articleDescription\":\""+"一个黑色的钱包"+
        //        "\",\"articleLocal\":\""+"3区2栋604"+
        //        "\",\"articleImage\":\""+"/img/article/kk.png"+
        //        "\",\"articleContact\":\""+"18229738222"+
        //        "\",\"articleAddress\":\""+"牛耳实训基地"+
        //        "\"}]";

        PrintWriter printWriter = response.getWriter();
        printWriter.print(json);
        printWriter.flush();
        printWriter.close();
    }

}
