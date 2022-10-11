import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

class User{
    String name;
    String email;
    String username;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}

class UserBO{
    public void readFromFile(BufferedReader br){
        String i = "";
        try {
            while ((i = br.readLine()) != null) {
                System.out.print(i);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void display(List<User> list){
    }
}

public class q1 {


    public static void main(String[] args) {
        UserBO u = new UserBO();
        try {
            FileReader fr = new FileReader("Z:\\SEM 5\\20XW57 JAVA PROGRAMMING LAB\\ws10-Files\\input.csv");
            BufferedReader br =new BufferedReader(fr);
            u.readFromFile(br);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}