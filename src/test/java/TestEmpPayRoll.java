import org.junit.*;

public class TestEmpPayRoll {
    EmployeeMain e=new EmployeeMain();

    @Before
    public void initiate()
    {
        int count=0;
        EmployeePayRoll a=new EmployeePayRoll(1,"a",1);
        EmployeePayRoll b=new EmployeePayRoll(2,"b",2);
        EmployeePayRoll c=new EmployeePayRoll(3,"c",3);
        e.arr.add(a);
        e.arr.add(b);
        e.arr.add(c);
    }

    @Test
    public void test1CheckCountOfWrittenFiles(){
        e.writeFile();
        Assert.assertEquals(3,e.countEntries());
    }
    @Test
    public void test2CheckCountOfReadFiles(){
        e.readFile();
        Assert.assertEquals(3,e.countEntries());
    }


}
