import MyPackage.InsuredPackage;
import MyPackage.Package;

public class UsePackage {
    public static void main(String[] args) {
        Package p1 = new Package(5,'A');
        System.out.println(p1.toString());
        InsuredPackage i1 = new InsuredPackage(6,'T');
        System.out.println(i1.toString());
    }
}
