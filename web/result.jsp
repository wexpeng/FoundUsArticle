<%--
  Created by IntelliJ IDEA.
  User: Wexpeng
  Date: 2019-05-25
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>

        *{
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
        }
        body{
            font-family: Helvetica;
            -webkit-font-smoothing: antialiased;
            background: rgba( 71, 147, 227, 1);
        }
        h2{
            text-align: center;
            font-size: 28px;
            text-transform: uppercase;
            letter-spacing: 1px;
            color: white;
            padding: 30px 0;
        }

        /* Table Styles */

        .table-wrapper{
            margin: 10px 70px 70px;
            box-shadow: 0px 35px 50px rgba( 0, 0, 0, 0.2 );
        }

        .fl-table {
            border-radius: 5px;
            font-size: 12px;
            font-weight: normal;
            border: none;
            border-collapse: collapse;
            width: 100%;
            max-width: 100%;
            white-space: nowrap;
            background-color: white;
        }

        .fl-table td, .fl-table th {
            text-align: center;
            padding: 8px;
        }

        .fl-table td {
            border-right: 1px solid #f8f8f8;
            font-size: 12px;
        }

        .fl-table thead th {
            color: #ffffff;
            background: #4FC3A1;
        }


        .fl-table thead th:nth-child(odd) {
            color: #ffffff;
            background: #324960;
        }

        .fl-table tr:nth-child(even) {
            background: #F8F8F8;
        }
    </style>


    <title>搜索结果</title>
    <%@page import="lostFound.bean.Article" %>
    <%@page import="java.util.ArrayList" %>
    <%@ page import="lostFound.dao.ArticleDao" %>

</head>
<body>

<h1 align="center"><br></h1><h2 align="center">物品列表</h2>
<div class="table-wrapper">
    <form action="#">
        <input type="hidden" name="id">
        <table class="fl-table" align="center" border="1" width="80%">
            <tr>
                <th>物品</th>
                <th>拾到地点</th>
                <th>联系地址</th>
                <th>照片</th>
                <th>电话号码</th>
            </tr>
            <%
                String key = request.getParameter("searchKey");//得到搜索框get的值
                ArticleDao articleDao = new ArticleDao();
                ArrayList list = articleDao.getArticle(key);
            %>
            <%for(int i=0;i<list.size();i++){
                Article article = new Article();

                article= (Article) list.get(i);%>
            <tr>
                <td><%=article.getArticleDescription()%></td>
                <td><%=article.getArticleAddress()%></td>
                <td><%=article.getArticleLocal()%></td>
                <td><img src="<%=article.getArticleImage()%>"></td>
                <td><%=article.getArticleContact()%></td>
            </tr>
            <%}%>
        </table>
    </form>
</div>



</body>
</html>
