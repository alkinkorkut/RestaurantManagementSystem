package restaurantManagement;

public class Waiter implements Employee {
    private int id;
    private String name;
    private double salary;
    private double taxRate = 0.18;
    private double orderRate=0.10;


    public Waiter(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public double getTaxRate() {return this.taxRate;}

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public double calculateExpense() {
        return getSalary() * getTaxRate() + getSalary();
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Waiter "+(this.getId())+": "+this.getName();
    }



}
