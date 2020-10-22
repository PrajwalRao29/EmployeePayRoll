import java.util.*;

public class EmployeeMain {
    ArrayList<EmployeePayRoll> arr=new ArrayList<EmployeePayRoll>();

    public void readDetails()
    {
        Scanner sc=new Scanner(System.in);
        EmployeePayRoll e=new EmployeePayRoll();
        System.out.println("Enter Employee id");
        e.setId(sc.nextInt());
        System.out.println("Enter Employee Name");
        e.setName(sc.next());
        System.out.println("Enter Employee Salary");
        e.setSalary(sc.nextLong());
        arr.add(e);
    }
    public void writeDetails()
    {
        for(EmployeePayRoll e:arr)
        {
            System.out.println("Employee ID: "+e.getId());
            System.out.println("Employee Name: "+e.getName());
            System.out.println("Employee Salary: "+e.getSalary());
        }
    }

    public static void main(String[] args) {
        EmployeeMain e=new EmployeeMain();
        System.out.println("READING INPUT FROM CONSOLE");
        e.readDetails();
        System.out.println("WRITING DATA TO CONSOLE");
        e.writeDetails();
    }
}