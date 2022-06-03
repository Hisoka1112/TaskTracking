package DataSource;
import Model.Subtask;
import Model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DataSource.DataBse.base;

public class SubtaskDAO implements DAO<Subtask> {
    @Override
    public void insert(Subtask subtask) throws SQLException {
        PreparedStatement a= base().prepareStatement("insert into subtask(Name,Time)values(?,?);");
        a.setString(1,subtask.getName());
        a.setInt(2,subtask.getTime());
        a.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement a= base().prepareStatement("delete from subtask where id=?;");
        a.setInt(1,id);
        a.executeUpdate();
    }

    @Override
    public void getAll() throws SQLException {
        PreparedStatement a= base().prepareStatement("SELECT * FROM subtask;");
        ResultSet s= a.executeQuery();
        while(s.next()){
            System.out.println(s.getInt(1)+" "+s.getString(2));
        }
    }
}
