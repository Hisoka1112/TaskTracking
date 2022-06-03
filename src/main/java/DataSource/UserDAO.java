package DataSource;

import Model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DataSource.DataBse.base;

public  class UserDAO implements DAO<User> {

    @Override
    public  void insert(User user) throws SQLException {
        PreparedStatement a= base().prepareStatement("insert into users(Name)values(?);");
        a.setString(1,User.class.getName());
        a.executeUpdate();
    }
    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement a= base().prepareStatement("delete from users where id=?;");
        a.setInt(1,id);
        a.executeUpdate();
    }
    @Override
    public void getAll() throws SQLException {
        PreparedStatement a= base().prepareStatement("select ProjectId,Name from users;");
        ResultSet s= a.executeQuery();
        while(s.next()){
            System.out.println(s.getInt(1)+" "+s.getString(2));
        }
    }
}
