package lostFound.dao;

import lostFound.bean.Article;
import lostFound.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

public class ArticleDao {

    ResultSet resultSet = null;
    ArrayList<Article> articleList = new ArrayList<Article>();
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    //获取所有物品
    public ArrayList<Article> getArticle() {

        String sql = "select * from article";
        return printArticle(sql);
    }

    //查询一个物品
    public ArrayList<Article> getArticle(String searchKey) {
        String sql = "select * from article where articleDescription like \"%"+ searchKey+"%\"";
        System.out.print(sql);
        return printArticle(sql);
    }

    private ArrayList<Article> printArticle(String sql){

        try {
            Connection connection = DBUtil.getConnection();
            //获得数据库连接
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Article article = new Article();
                article.setArticleId(resultSet.getInt("articleId"));
                article.setArticleDescription(resultSet.getString("articleDescription"));
                //article.setArticleTime(resultSet.getDate("articleTime"));
                article.setArticleLocal(resultSet.getString("articleLocal"));
                article.setArticleContact(resultSet.getString("articleContact"));
                article.setArticleAddress(resultSet.getString("articleAddress"));
                article.setArticleImage(resultSet.getString("articleImage"));
                articleList.add(article);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(connection, preparedStatement, resultSet);
        }

        return articleList;
    }





    //新增一个物品
    public void addArticle(Article article) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into article (articleId,articleDescription,articleLocal,articleContact,articleAddress,articleWebsite,articleImage) values(null,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, article.getArticleDescription());
            //preparedStatement.setDate(2, (Date) article.getArticleTime());
            preparedStatement.setString(2,article.getArticleLocal());
            preparedStatement.setString(3, article.getArticleContact());
            preparedStatement.setString(4, article.getArticleAddress());
            preparedStatement.setString(5,article.getArticleWebsite());
            preparedStatement.setString(6,article.getArticleImage());
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(connection,preparedStatement,null);
        }
    }
    //删除商品
    public void delArticle(int articleId){
        Connection connection = DBUtil.getConnection();
        String sql = "delete from article where article = ? ";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,articleId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(connection, preparedStatement, null);
        }
    }

}
