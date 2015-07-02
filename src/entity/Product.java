package entity;

public class Product {

    private int code, id;
    private String name;
    private double price;

    public Product(int code, String name, double price) {
        this.setCode(code);
        this.setName(name);
        this.setPrice(price);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        result.append(String.format("| %-6s ", this.getCode()));
        result.append(String.format("| %-12s ", this.getName()));
        result.append(String.format("| %-8s |\n", this.getPrice()));

        return result.toString();
    }
}
