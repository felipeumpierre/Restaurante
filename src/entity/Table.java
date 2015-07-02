package entity;

public class Table {

    private int number, capacity, id, available;

    public Table(int number, int capacity) {
        this.setNumber(number);
        this.setCapacity(capacity);
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("| %-3s ", this.getId()));
        result.append(String.format("| %-3s ", this.getNumber()));
        result.append(String.format("| %-3s ", this.getCapacity()));
        result.append(String.format("| %-10s |\n", this.getAvailable() == 1 ? "Disponivel" : "Ocupado"));

        return result.toString();
    }
}
