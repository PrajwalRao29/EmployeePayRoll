import java.io.*;
import java.nio.file.*;
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
    public Boolean writeFile() {
        try {
            Scanner sc=new Scanner(System.in);
            EmployeePayRoll e=new EmployeePayRoll();
            Path p=Paths.get("C:\\Users\\Latha r rao\\Intellij\\EmployeePayRoll\\EmpData\\DATA.txt");
            StringBuffer s=new StringBuffer();
            for (EmployeePayRoll z : arr) {
                String x = z.toString()+"\n";
                s.append(x);
            }
            Files.write(p,s.toString().getBytes());
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void readFile(){
        try{
            FileReader f = new FileReader("C:\\Users\\Latha r rao\\Intellij\\EmployeePayRoll\\EmpData\\DATA.txt");
            int i;
            while((i=f.read())!=-1)
                System.out.print((char)i);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public long countEntries()
    {
        long count=0;
        {
            Path p=Paths.get("C:\\Users\\Latha r rao\\Intellij\\EmployeePayRoll\\EmpData\\DATA.txt");
            try {
                count=Files.lines(p).count();
                return count;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}