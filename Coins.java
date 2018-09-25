import java.util.*;

public class Coins {
    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        int coins, reveals, spins;

        System.out.println("How many coins in play?: ");
        coins = in.nextInt();

        System.out.println("How many do you wish to reveal each turn?: ");
        reveals = in.nextInt();

        System.out.println("How many spins?: ");
        spins = in.nextInt();

        in.close();

        Wheel gameWheel = new Wheel(coins, reveals, spins);
        System.out.println(gameWheel.toString());
    }
}
