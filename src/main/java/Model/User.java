package Model;

public class User {
    private int id;
    private String Name;
    private int ProjectId;

    public User(int id, String name, int projectId) {
        this.id = id;
        Name = name;
        ProjectId = projectId;
    }

    public User(){

    }
    public User(String name){
        Name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }
}
