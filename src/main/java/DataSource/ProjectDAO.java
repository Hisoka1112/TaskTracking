package DataSource;

import Model.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DataSource.DataBse.base;

public class ProjectDAO implements DAO<Project> {
    @Override
    public  void insert(Project project) throws SQLException {
        PreparedStatement a= base().prepareStatement("insert into project(Name)values(?);");
        a.setString(1,project.getName());
        a.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement a= base().prepareStatement("delete from project where id=?;");
        a.setInt(1,id);
        a.executeUpdate();
    }
    @Override
    public void getAll() throws SQLException {
        PreparedStatement a= base().prepareStatement("SELECT * FROM project");
       ResultSet s= a.executeQuery();
        while(s.next()){
            System.out.println(s.getInt(1)+" "+s.getString(2));
        }
    }
}
