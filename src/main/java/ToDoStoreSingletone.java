import java.util.*;

public class ToDoStoreSingletone implements AddingItem, ChangingStatus, RemovingItem, PrintingItem {
    private static ToDoStoreSingletone instance = null;
    final Map<String, Item> items = new LinkedHashMap<>();
    private String uuid = null;
    protected ToDoStoreSingletone(){
    }

    public static ToDoStoreSingletone Instance() {
        if (instance==null) {
            instance = new ToDoStoreSingletone();
            return instance;
        }
        else
            return null;
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public String getUuid() {
        UUID id = UUID.randomUUID();
        uuid = id.toString();
        return uuid;
    }

    /**
     * This method adds a new task to todo list
     * @param s - it's a task, which must be added
     */
    public void addItem(String s){
        items.put(getUuid(), new Item(s, Status.INCOMPLETED));
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
