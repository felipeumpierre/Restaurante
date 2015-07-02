package entity;

public class Waiter {

    private int id;
    private String name, cpf;
    private double salary;

    public Waiter(String name, String cpf, double salary) {
        this.setName(name);
        this.setCpf(cpf);
        this.setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
        result.append(String.format("| %-12s ", this.getName()));
        result.append(String.format("| %-12s ", this.getCpf()));
        result.append(String.format("| %-8s |\n", this.getSalary()));

        return result.toString();
    }
}
