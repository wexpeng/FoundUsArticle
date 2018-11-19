package lostFound.util;

import java.sql.*;

public class DBUtil {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/lostandfound?serverTimezone=UTC";
    private static String user = "root";
    private static String password = "root";
    //为了方便，使用的是mysql8.0，连接的jar包略有不同。

    //获取链接
    public static Connection getConnection() {
        Connection connection = null;
        //加载驱动
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
        //这里仅仅用于测试
        try {
            System.out.println(connection.getSchema());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
