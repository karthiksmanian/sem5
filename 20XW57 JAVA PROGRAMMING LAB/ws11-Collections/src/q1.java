import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class Card implements Comparable<Card>{
    char symbol;
    int number;

    public Card() {
    }

    public Card(char symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    @Override
    public int compareTo(Card c){
        if(this.symbol>c.symbol){
            return 1;
        } else if (this.symbol<c.symbol) {
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
public class q1 {
    public static void main(String[] args) {
        Set<Card> cardSet = new HashSet<Card>();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the no of cards:");
        int n = input.nextInt();
        Card[] cards = new Card[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter a card");
            char s = input.next().charAt(0);
            int no = input.nextInt();
            cards[i] = new Card(s,no);
            cardSet.add(cards[i]);
        }

        for (Card k:
             cardSet) {
            System.out.printf("%c%d",k.symbol,k.number);
        }
    }

}
