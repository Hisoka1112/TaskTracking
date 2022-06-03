package Model;

public class Subtask {
    private int id;
    private String Name;
    private int TaskId;

    private int Time;

    public Subtask(int id, String name, int taskId, int time) {
        this.id = id;
        Name = name;
        TaskId = taskId;
        Time = time;
    }

    public Subtask(){

    }

    public Subtask(String name, int time) {
       this. Name = name;
        this.Time = time;
    }

    public Subtask(String Name){
        this.Name=Name;
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

    public int getTaskId() {
        return TaskId;
    }

    public void setTaskId(int taskId) {
        TaskId = taskId;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        Time = time;
    }
}
