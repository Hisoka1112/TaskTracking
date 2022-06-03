package DataSource;

import Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBse {

    public static Connection base() throws SQLException {
        String url="jdbc:mysql://localhost:3306/test2";
        String login="root";
        String password="";
        Connection data= DriverManager.getConnection(url,login,password);
        return data;
    }
    public static void AddUser() throws SQLException {

    }
}
