package lostFound.util;

import java.sql.*;
import java.util.ArrayList;

public class DBUtil {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/lostandfound?useSSL=false";
    private static String user = "root";
    private static String password = "root";

    //获取链接
    public static Connection getConnection() {
        Connection connection = null;
        //加载驱动
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //
    public static void closeConn(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        try {
            System.out.println(connection.getSchema());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
