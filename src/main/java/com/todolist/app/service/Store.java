package com.todolist.app.service;
import com.todolist.app.model.Status;





public interface Store {
    /**
     * This method adds a new task to todo list
     * @param s - it's a task, which must be added
     */
    void addItem(String s);

    /**
     * This method changes status of task
     * @param number - it's a number of task in map
     * @param st - it's a new status for task
     */
    void changeStatus(int number, Status st);

    /**
     * This method removed a task from todo list
     * @param number - it's a number of task in map
     */
    void removeItem(int number);

    /**
     * This method select items from todo list and prints it
     */
    void printAll();
}
