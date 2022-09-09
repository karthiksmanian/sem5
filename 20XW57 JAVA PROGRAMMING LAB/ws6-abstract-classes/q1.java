import java.util.Scanner;

abstract class FundTransfer{
//    attributes
    String accountNumber;
    Double balance;

//    constructor
    public FundTransfer() {
    }

//    methods
    Boolean validate(Double transfer){
//        to be written
        return null;
    }

    abstract Boolean transfer(Double transfer);
}

class NEFTTransfer extends FundTransfer{
    @Override
    Boolean transfer(Double transfer) {
//        to be written
        return null;
    }
}

class IMPSTransfer extends FundTransfer{
    @Override
    Boolean transfer(Double transfer) {
//        to be written
        return null;
    }
}

class RTGStransfer extends FundTransfer{
    @Override
    Boolean transfer(Double transfer) {
//        to be writtern
        return null;
    }
}

public class q1 {
    public static void main(String[] args) {
//        System.out.println("hello star platinum");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the account number :");
        int accountNumber = input.nextInt();
        System.out.println("Enter the account balance:");
        double balance = input.nextDouble();

        System.out.println("Enter the type of transaction to be made:");
        System.out.printf("1.NEFT\n2.IMPS\n3.RTGS\n");
        int ch = input.nextInt();

        switch (ch){
            case 1:

        }
    }
}
