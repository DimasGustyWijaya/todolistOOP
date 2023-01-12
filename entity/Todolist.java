package entity;

public class Todolist {
    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public Todolist(String todo){
        this.todo = todo;
    }

    public Todolist(){

    }

    private String todo;


}
