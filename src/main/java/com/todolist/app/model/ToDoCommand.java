package com.todolist.app.model;





public class ToDoCommand {
    private int number;
    private Command command;
    private String description;

    public ToDoCommand(int newNumber, Command newCommand, String newDescription){
        this.number = newNumber;
        this.command = newCommand;
        this.description = newDescription;
    }

    public int getNumber() {
        return number;
    }

    public Command getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        return number + ". " + command + description;
    }
}
