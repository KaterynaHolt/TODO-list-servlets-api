public interface Store {
    public void addItem(String s);
    public void changeStatus(int number, Status st);
    public void removeItem(int number);
    public void printAll();
}
