public class EmployeePayRoll {
    private int id;
    private String name;
    private long salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmployeePayRoll(int id, String name, long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public EmployeePayRoll() {
    }

    @Override
    public String toString() {
        return "id= " + id + ", name= " + name + ", salary= " + salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
