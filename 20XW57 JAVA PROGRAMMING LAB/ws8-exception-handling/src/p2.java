import java.util.Scanner;

public class p2 {

    static void printArray (int[] arr,int n)
    {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ",arr[count]);
                count++;
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of rows and columns of the show:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] seats = new int[n * n];

        System.out.println("Enter the number of seats to be booked");
        int nos = input.nextInt();

        for (int i = 0; i < nos; i++) {
            System.out.printf("Enter the seat no %d", i + 1);
            int sno = input.nextInt();

            try {
                if (seats[sno] == 1)
                {
                    throw new SeatNotAvailableException("SeatNotAvailableException: Already Booked/");
                }else{
                    seats[sno] = 1;
                }
            }catch(ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            }catch(SeatNotAvailableException e){
                System.out.println(e);
            }
        }
        System.out.println("Seats booked :");
        printArray(seats,n);
    }
}

class SeatNotAvailableException extends Exception{
    public SeatNotAvailableException(String s){
        super(s);
    }
}