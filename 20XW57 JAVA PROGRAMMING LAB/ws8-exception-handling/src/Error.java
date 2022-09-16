
public class Error {
    public static void main(String[] args) {
        int a = 10;
        int b=5,c = 5;
        int x,y;

        try{
            x = a/(b-c);
        }
        catch (ArithmeticException e){
            System.out.println("Div. by zero.");
        }
        y=a/(b+c);
        System.out.println("y ="+y);
    }
}
