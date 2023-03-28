package com.todolist.app.model;
import java.util.ArrayList;
import java.util.List;





public class Item {
    private String value;
    private Status status;
    private Priority priority;
    private String date;
    private List<Tag> tags;
    public Item(String value, Status status, Priority priority, String date){
        this.value = value;
        this.status = status;
        this.priority = priority;
        this.date = date;
        this.tags = new ArrayList<>();
    }

    public Item(String value, Status status){
        this.value = value;
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getDate() {
        return date;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return value + ", " + date + ", " + status + ", " + priority + ", " + tags.toString();
    }
}
