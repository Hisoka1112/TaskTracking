package DataSource;
import java.sql.SQLException;
import Model.Project;
import Model.Task;
import Model.User;
import java.sql.Connection;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class InnitDataBase {
    public static ArrayList<String> readProjectFromFile() throws IOException {
        ArrayList<String>chel= new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("Project"));
        String line="";
        while ((line=br.readLine())!= null) {
            chel.add(line);
        }
        return chel;
    }
    public static void addProjectToBaseList() throws IOException, SQLException {
        ArrayList<String> list=readProjectFromFile();
         ProjectDAO projectgDAO =new ProjectDAO();
         for(int i=0;i< list.size();i++){
             Project project =new Project(list.get(i));
             projectgDAO.insert(project);
         }
    }
    public static ArrayList<String> UserList() throws IOException {
        ArrayList<String>list=new ArrayList<>();
         BufferedReader br = new BufferedReader (new FileReader("Users"));
            String line = "";
            while ((line = br.readLine()) != null){
                list.add(line);
      }
            return list;
    }
    public static void addBaseUsersList() throws IOException, SQLException {
       ArrayList<String>chel= UserList();
        for(String i:chel){
            UserDAO userDAO=new UserDAO();
            User users=new User(i);
            userDAO.insert(users);
        }
    }
    public static void addBaseTask() throws IOException, SQLException {
        BufferedReader br = new BufferedReader (new FileReader("Task"));
        String line="";
        while((line= br.readLine()) !=null){
            Task task=new Task(line);
            TaskDAO taskDAO=new TaskDAO();
            taskDAO.insert(task);
        }
    }
    public static void innit() throws SQLException, IOException {
        createProjectTable();
        createUsersTable();
        createTaskTable();
        addProjectToBaseList();
        addBaseUsersList();
        addBaseTask();
    }

    public static void createProjectTable() throws SQLException {
        PreparedStatement a=DataBse.base().prepareStatement(
                "CREATE TABLE `project` (" +
                "  `id` int NOT NULL AUTO_INCREMENT," +
                "  `Name` varchar(45) NOT NULL," +
                "  PRIMARY KEY (`id`)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;");
        a.executeUpdate();
    }
    public static void createUsersTable() throws SQLException {
        PreparedStatement a=DataBse.base().prepareStatement(
                "CREATE TABLE `users` (" +
                "  `id` int NOT NULL AUTO_INCREMENT," +
                "  `Name` varchar(45) NOT NULL," +
                "  `ProjectId` int DEFAULT NULL," +
                "  PRIMARY KEY (`id`)," +
                "  KEY `project_idx` (`ProjectId`)," +
                "  CONSTRAINT `project` FOREIGN KEY (`ProjectId`) REFERENCES `project` (`id`)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;");
        a.executeUpdate();
    }
    public static void createTaskTable() throws SQLException {
        PreparedStatement a=DataBse.base().prepareStatement(
                "CREATE TABLE `task` (" +
                "  `id` int NOT NULL AUTO_INCREMENT," +
                "  `Name` varchar(45) NOT NULL," +
                "  `TaskUserId` int DEFAULT NULL," +
                "  PRIMARY KEY (`id`)," +
                "  KEY `User_idx` (`TaskUserId`)," +
                "  CONSTRAINT `User` FOREIGN KEY (`TaskUserId`) REFERENCES `users` (`id`)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;");
        a.executeUpdate();
    }
}
