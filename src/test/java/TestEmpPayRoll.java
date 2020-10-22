import org.junit.*;

public class TestEmpPayRoll {

    @Test
    public void test1CheckCountOfWrittenFiles(){
        EmployeeMain e=new EmployeeMain();
        int count=0;
        EmployeePayRoll a=new EmployeePayRoll(1,"a",1);
        EmployeePayRoll b=new EmployeePayRoll(2,"b",2);
        EmployeePayRoll c=new EmployeePayRoll(3,"c",3);
        e.arr.add(a);
        e.arr.add(b);
        e.arr.add(c);
        e.writeFile();
        Assert.assertEquals(3,e.countEntries());
    }
}
