package Model;

public class Project {
    private int id;
    private String Name;

    public Project(int id, String name) {
        this.id = id;
        Name = name;
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
    public Project(){

    }
    public Project(String name){
        Name=name;
    }
}
