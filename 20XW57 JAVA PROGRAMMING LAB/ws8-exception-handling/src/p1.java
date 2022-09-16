import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        System.out.println("Enter the number of seats:");
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int[] seats = new int[101];

        for (int i = 0; i < x; i++) {
            System.out.println("Enter the seat no.");
            int sno = input.nextInt();
            try {
                seats[sno] = 1;
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e);
            }
        }
        System.out.println("Booked Seats:");
        for(int i =0; i<seats.length;i++){
            if(seats[i]==1)
            {
                System.out.println(i);
            }
        }
    }
}
