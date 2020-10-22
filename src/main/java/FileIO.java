import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class FileIO {

    public static void main(String[] args) {
        FileIO f=new FileIO();
        f.createDirectory();
        f.createFile();
        f.ListFiles();
    }

    public void createFile() {
        IntStream.range(1, 10).forEach(c ->
        {
            Path path = Paths.get("C:\\Users\\Latha r rao\\Intellij\\EmployeePayRoll\\EmpData" + "\\temp" + c+".txt");
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public boolean createDirectory() {
        Path path = Paths.get("C:\\Users\\Latha r rao\\Intellij\\EmployeePayRoll\\EmpData\\NewDirectory");
        try {
            Files.createDirectory(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void ListFiles() {
        Path path = Paths.get("C:\\Users\\Latha r rao\\Intellij\\EmployeePayRoll\\EmpData");
        try {
            Files.list(path).filter(Files::isRegularFile).forEach(System.out::println);
            Files.newDirectoryStream(path).forEach(System.out::println);
            Files.newDirectoryStream(path, p -> p.toFile().isFile() && p.toString().startsWith("temp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}