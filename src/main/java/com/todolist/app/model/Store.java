package com.todolist.app.model;
public interface Store {
    /**
     * This method adds a new task to todo list
     * @param s - it's a task, which must be added
     */
    public void addItem(String s);

    /**
     * This method changes status of task
     * @param number - it's a number of task in map
     * @param st - it's a new status for task
     */
    public void changeStatus(int number, Status st);

    /**
     * This method removed a task from todo list
     * @param number - it's a number of task in map
     */
    public void removeItem(int number);

    /**
     * This method select items from todo list and prints it
     */
    public void printAll();
}
