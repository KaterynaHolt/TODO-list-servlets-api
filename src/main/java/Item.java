public class Item {
    private String value;
    private Status status;
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

    public void setValue(String value) {
        this.value = value;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
