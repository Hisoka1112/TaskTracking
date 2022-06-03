package Model;

public class Task {
    private int id;
    private String Name;

    public Task(int id, String Name) {
        this.id = id;
        Name = Name;
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
    public Task(){

    }
    public Task(String Name){
       this. Name=Name;
    }

}
