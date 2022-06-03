package DataSource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static DataSource.DataBse.base;

public  class addUserByProject {

    public void AddUserByProject(int ProjectId,int id) throws SQLException {
        if(CheckUser(id)&&CheckProjectById(ProjectId)){
            PreparedStatement a=base().prepareStatement("update users set ProjectId=? where id=?;");
            a.setInt(1,ProjectId);
            a.setInt(2,id);
            a.executeUpdate();
        }
    }
    public void AddUserByTask(int TaskUserId,int id) throws SQLException {
        if(CheckTask(id)&&CheckUser(TaskUserId)) {
            PreparedStatement a = base().prepareStatement("update task set TaskUserId=? where id=?");
            a.setInt(1, TaskUserId);
            a.setInt(2, id);
            a.executeUpdate();
        }
    }
    public boolean CheckUser(int id) throws SQLException {
        PreparedStatement a= base().prepareStatement("select * from users where id=?;");
        a.setInt(1,id);
        ResultSet s=a.executeQuery();
        while(s.next()){
            return true;
        }
        return false;
    }
    public boolean CheckProjectById(int projectId) throws SQLException {
        PreparedStatement a= base().prepareStatement("select * from project where id=?");
        a.setInt(1,projectId);
        ResultSet s=a.executeQuery();
        while(s.next()){
            return true;
        }
        return false;
    }
    public boolean CheckTask(int id) throws SQLException {
        PreparedStatement a= base().prepareStatement("select * from task where  id=?");
        a.setInt(1,id);
        ResultSet s=a.executeQuery();
        while(s.next()){
            return true;
        }
        return false;
    }
    public static ArrayList<String>  Report(int Pid,int Uid) throws SQLException {
        PreparedStatement a= base().prepareStatement("select t.Name from task as t inner join users as u on t.TaskUserId=u.id inner join project as p on u.ProjectId=p.id\n" +
                " where p.id=? and u.id=?;");
        a.setInt(1,Pid);
        a.setInt(2,Uid);
        ResultSet s=a.executeQuery();
        ArrayList<String> chel=new ArrayList<>();
        while(s.next()){
            chel.add(s.getString(1));
        }
        return chel;
    }
    public  void assignmentsSubTask(int id, int TaskId) throws SQLException {
        if(checkSubtask(id)&&CheckTask(TaskId)){
            PreparedStatement a= base().prepareStatement("update subtask set TaskId=? where id=?");
            a.setInt(1,TaskId);
            a.setInt(2,id);
            a.executeUpdate();
        }
    }
    public static boolean checkSubtask(int id) throws SQLException {
        PreparedStatement a= base().prepareStatement("select * from subtask where id=?");
        a.setInt(1,id);
        ResultSet s=a.executeQuery();
        while(s.next()){
            s.getInt(1);
            return true;
        }
        return false;
    }
    public static void deleteTaskBySubtask(int id) throws SQLException {
        ArrayList<Integer>list=new ArrayList<>();
        PreparedStatement a= base().prepareStatement("select * from subtask where TaskId=? ");
        a.setInt(1,id);
        ResultSet s=a.executeQuery();
        while(s.next()){
            list.add(s.getInt(1));
        }
        a.close();
    }
    public static void deleteTask(int id) throws SQLException {
        deleteSubTask(id);
        PreparedStatement a= base().prepareStatement("delete from task where id=?");
        a.setInt(1,id);
        a.executeUpdate();
    }
     private static void deleteSubTask(int TaskId) throws SQLException {
        PreparedStatement a= base().prepareStatement("delete from subtask where TaskId=?");
        a.setInt(1,TaskId);
        a.executeUpdate();
    }
    public static Integer sumTime(int TaskId) throws SQLException {
        PreparedStatement a= base().prepareStatement("select sum(Time) from subtask where TaskId=?;");
        a.setInt(1,TaskId);
       ResultSet s= a.executeQuery();
       while(s.next()){
          return s.getInt(1);
       }
       return 0;
    }
}
