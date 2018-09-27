import java.util.*;

public class Coins {
    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        int coins, reveals, spins;
        String inputPrompt;

        inputPrompt = "How many coins in play?: ";
        coins = getInput(in, inputPrompt);

        inputPrompt = "How many coins do you wish to reveal each turn?: ";
        while( (reveals = getInput(in, inputPrompt)) > coins) 
            System.out.println("Invalid input: Number of reveals cannot be greater than number of coins.");

        inputPrompt = "How many spins?: ";
        spins = getInput(in, inputPrompt);


        in.close();

        Wheel gameWheel = new Wheel(coins, reveals, spins);
        System.out.println(gameWheel.toString());
        gameWheel.userWheel(coins, reveals);

        if (gameWheel.checkWheel())
            System.out.println("Congrats! You Win!");
    }

    /**
    *   Asks user to input a number, then checks if it's valid,
    *   and if it's not, asks again
    *
    *   @param in Scanner to use for console input
    *   @param inputPrompt What to ask the user
    *
    *   @return the valid number the user entered
    */
    public static int getInput(Scanner in, String inputPrompt) {
        int input = 0;
        while(true) {
            System.out.println(inputPrompt);
            try {
                input = in.nextInt();

                //Check the user's input is a valid number
                if(input <= 0)
                    System.out.println("\nInvalid input: The number must be greater than zero.");
                else
                    return input;

            } catch(Exception e) {
                //Have Scanner consume the invalid input
                in.next();
                System.out.println("\nInvalid input: Not a number.");
            }
        }
    }
}
