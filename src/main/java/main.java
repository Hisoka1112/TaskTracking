import DataSource.*;
import Model.Project;
import Model.Subtask;
import Model.Task;
import Model.User;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws SQLException, IOException {
        InnitDataBase.innit();
        Scanner scanner=new Scanner(System.in);
        ProjectDAO projectDAO=new ProjectDAO();
        UserDAO userDAO=new UserDAO();
        TaskDAO taskDAO=new TaskDAO();
        SubtaskDAO subtaskDAO=new SubtaskDAO();
        while(true){
            System.out.println("1-Project");
            System.out.println("2 Users");
            System.out.println("3 Task");
            System.out.println("4 Subtask");
            String a=scanner.nextLine();
            if(a.equals("1")){
                System.out.println("1-create Project");
                System.out.println("2-delete Project");
                System.out.println("3-output Project");
                System.out.println("Enter the number");
                String choice=scanner.nextLine();
                if(choice.equals("1")){
                    System.out.println("Enter a project ");
                    String name=scanner.nextLine();
                    Project project =new Project(name);
                    projectDAO.insert(project);
                }
                if(choice.equals("2")){
                    System.out.println("Enter a id for deletion");
                   int id= scanner.nextInt();
                    projectDAO.delete(id);

                }
                if(choice.equals("3")){
                    projectDAO.getAll();
                }
            }
            else if(a.equals("2")){
                System.out.println("1-create User");
                System.out.println("2-delete User");
                System.out.println("3-output User");
                String choice=scanner.nextLine();
                if(choice.equals("1")){
                    System.out.println("Enter the User");
                    String name=scanner.nextLine();
                    User user=new User(name);
                    userDAO.insert(user);
                }
                if(choice.equals("2")){
                    System.out.println("Enter a id for deletion");
                    int id= scanner.nextInt();
                    userDAO.delete(id);
                }
                if(choice.equals("3")){
                    userDAO.getAll();
                }
            }
            else if(a.equals("3")){
                System.out.println("1-create Task");
                System.out.println("2-delete Task");
                System.out.println("3-output Task");
                String choice=scanner.nextLine();
                if(choice.equals("1")){
                    System.out.println("Enter the Task");
                    String name=scanner.nextLine();
                    Task task=new Task(name);
                    taskDAO.insert(task);
                }
                if(choice.equals("2")){
                    System.out.println("Enter a id for deletion");
                    int id= scanner.nextInt();
                    taskDAO.delete(id);
                }
                if(choice.equals("3")){
                    taskDAO.getAll();
                }
            }
            else if(a.equals("4")){
                System.out.println("1-create Subtask");
                System.out.println("2-delete Subtask");
                System.out.println("3-output Subtask");
                String choice=scanner.nextLine();
                if(choice.equals("1")){
                    System.out.println("Enter the Subtask");
                    String name=scanner.nextLine();
                    Subtask subtask =new Subtask(name);
                    subtaskDAO.insert(subtask);
                }
                if(choice.equals("2")){
                    System.out.println("Enter a id for deletion");
                    int id= scanner.nextInt();
                    subtaskDAO.delete(id);
                }
                if(choice.equals("3")){
                    subtaskDAO.getAll();
                }
            }
        }
    }
}
