package com.todolist.app.service;


import com.todolist.app.model.Item;
import com.todolist.app.model.Priority;
import com.todolist.app.model.Status;
import com.todolist.app.model.Tag;
import java.util.*;


public class ToDoStoreSingleton implements Store {
    private static ToDoStoreSingleton instance = null;
    private final Map<String, Item> items = new LinkedHashMap<>();
    protected ToDoStoreSingleton(){
    }

    public synchronized static ToDoStoreSingleton getInstance() {
        if (instance==null) {
            instance = new ToDoStoreSingleton();
            return instance;
        }
        else
            return instance;
    }

    public synchronized Map<String, Item> getItems() {
        return items;
    }

    public synchronized String getUuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * This method adds some tasks at the beginning
     */
    public void getExample(){
        List<Tag> tags1 = new ArrayList<>();
        tags1.add(Tag.WORK);
        tags1.add(Tag.READING);
        items.put(getUuid(), new Item("Task 1", "10.04.2023", Status.INPROGRESS, Priority.NORMAL, tags1));
        List<Tag> tags2 = new ArrayList<>();
        tags2.add(Tag.DAILYROUTINE);
        items.put(getUuid(), new Item("Task 2", "10.04.2023", Status.PENDING, Priority.MINOR, tags2));
        List<Tag> tags3 = new ArrayList<>();
        tags3.add(Tag.DAILYROUTINE);
        tags3.add(Tag.HOME);
        tags3.add(Tag.READING);
        items.put(getUuid(), new Item("Task 3", "10.04.2023", Status.COMPLETED, Priority.CRITICAL, tags3));
    }

    /**
     * This method adds a new task to todo list
     * @param item - it's a task, which must be added
     */
    public synchronized String addItem(Item item){
        String uuid = getUuid();
        items.put(uuid, item);
        return uuid;
    }

    /**
     * This method changes status of task
     * @param number - it's a number of task in map
     * @param st - it's a new status for task
     */
    public synchronized void changeStatus(int number, Status st){
        String key = (String) items.keySet().toArray()[number - 1];
        Item value = items.get(key);
        value.setStatus(st);
    }

    /**
     * This method removed a task from todo list
     * @param number - it's a number of task in map
     */
    public synchronized void removeItem(int number){
        String key = (String) items.keySet().toArray()[number - 1];
        items.remove(key);
    }

    /**
     * This method select items from todo list and prints it
     */
    public synchronized void printAll(){
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
