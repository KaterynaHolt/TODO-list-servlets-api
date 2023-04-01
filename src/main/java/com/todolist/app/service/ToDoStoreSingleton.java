package com.todolist.app.service;


import com.todolist.app.model.Item;
import com.todolist.app.model.Priority;
import com.todolist.app.model.Status;
import com.todolist.app.model.Tag;
import com.todolist.app.servlet.NewTaskServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class ToDoStoreSingleton implements Store {
    private Logger logger = LogManager.getLogger(ToDoStoreSingleton.class);
    private static ToDoStoreSingleton instance = null;
    private final Map<String, Item> items = new LinkedHashMap<>();
    protected ToDoStoreSingleton(){
    }

    public static ToDoStoreSingleton Instance() {
        if (instance==null) {
            instance = new ToDoStoreSingleton();
            return instance;
        }
        else
            return null;
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public String getUuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * This method adds a new task to todo list
     * @param item - it's a task, which must be added
     */
    public void addItem(Item item){
        items.put(getUuid(), item);
        logger.info("New task was added!");
    }

    /**
     * This method changes status of task
     * @param number - it's a number of task in map
     * @param st - it's a new status for task
     */
    public void changeStatus(int number, Status st){
        String key = (String) items.keySet().toArray()[number - 1];
        Item value = items.get(key);
        value.setStatus(st);
    }

    /**
     * This method removed a task from todo list
     * @param number - it's a number of task in map
     */
    public void removeItem(int number){
        String key = (String) items.keySet().toArray()[number - 1];
        items.remove(key);
    }

    /**
     * This method select items from todo list and prints it
     */
    public void printAll(){
        Formatter fm = new Formatter();
        int i = 1;
        System.out.println("=========TO DO LIST=============");
        System.out.println("|#  |    Title   |   Status   |");
        for(Map.Entry<String, Item> tasks : items.entrySet()){
            fm.format("%1s%1s%1s%11s%1s%11s%1s\n", "|", i, ". |", tasks.getValue().getValue(),
                    " |", tasks.getValue().getStatus(), " |");
            i++;
        }
        System.out.println(fm.toString().trim());
        System.out.println("================================");
        fm.close();
    }
}
