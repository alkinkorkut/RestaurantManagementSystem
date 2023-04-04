package restaurantManagement;

public interface Employee {

    public int getId();
    public void setId(int id);
    public String getName();
    public void setName(String name);
    public double calculateExpense();
    public double getSalary();
    public void setSalary(double salary);
    public String toString();
}
