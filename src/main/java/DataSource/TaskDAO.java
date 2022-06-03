package DataSource;

import Model.Task;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DataSource.DataBse.base;

public class TaskDAO implements DAO<Task> {

    @Override
    public void insert(Task task) throws SQLException {
        PreparedStatement a= base().prepareStatement("insert into task(Name)values(?);");
        a.setString(1, task.getName());
        a.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement a= base().prepareStatement("delete from task where id=?");
        a.setInt(1,id);
        a.executeUpdate();
    }

    @Override
    public void getAll() throws SQLException {
        PreparedStatement a= base().prepareStatement("select * from task");
        ResultSet s=a.executeQuery();
        while(s.next()){
            System.out.println(s.getInt(1)+" "+s.getString(2));
        }
    }
}
