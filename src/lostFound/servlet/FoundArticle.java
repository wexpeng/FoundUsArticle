package lostFound.servlet;

import lostFound.bean.Article;
import lostFound.dao.ArticleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
//新增物品servlet
@MultipartConfig
@WebServlet("/FoundArticle")
public class FoundArticle extends HttpServlet {
    private ArticleDao articleDao = new ArticleDao();
    private Article article = new Article();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //上传文件的组件
        Part part = request.getPart("articleImage");
        // 简单判断下，是不是图片类型
        String header = part.getHeader("Content-Disposition");
        int idx = header.lastIndexOf("filename=\"");
        String fileName = header.substring(idx+10, header.length()-1);
        String path = request.getSession().getServletContext().getRealPath("/") + "img/article/";
        // 获取上传的文件名
        File filePath = new File(path);
        // 保存文件
        part.write(path + fileName);





        String articleDescription = request.getParameter("articleDescription");
        //String articleTime = request.getParameter("articleTime");
        String articleLocal = request.getParameter("articleLocal");
        String articleImage = "img\\article\\"+fileName;
        String articleContact = request.getParameter("articleContact");
        String articleAddress = request.getParameter("articleAddress");

        article.setArticleDescription(articleDescription);
        article.setArticleLocal(articleLocal);
        article.setArticleContact(articleContact);
        article.setArticleAddress(articleAddress);
        article.setArticleWebsite("1");
        article.setArticleImage(articleImage);

        try {
            articleDao.addArticle(article);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(articleTime);

        PrintWriter printWriter = response.getWriter();
        printWriter.print("<script>window.history.back(-1);$('#splitlayout').attr(\"class\",\"splitlayout open-left\");<script>");


    }
}


