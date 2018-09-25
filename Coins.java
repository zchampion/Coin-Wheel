import java.util.*;

public class Coins {

    /*
     * Takes in the user input for the game information & builds the wheel.
     */
    public static void userInput(String[] sysArgs){

        Scanner in = new Scanner(System.in);
        int coins, reveals, spins;

        if (sysArgs.length >= 3) {

            coins = Integer.parseInt(sysArgs[0]);
            reveals = Integer.parseInt(sysArgs[1]);
            spins = Integer.parseInt(sysArgs[2]);

        } else {
            System.out.println("How many coins in play?: ");
            coins = in.nextInt();

            System.out.println("How many do you wish to reveal each turn?: ");
            reveals = in.nextInt();

            System.out.println("How many spins?: ");
            spins = in.nextInt();
        }

        buildWheel(coins, reveals, spins);

        in.close();
    }

    public static void buildWheel(int coins, int reveals, int spins){

        Random random = new Random();

        boolean[] wheel = new boolean[coins];

        for(int i = 0; i < coins; i++){

             wheel[i] = random.nextBoolean();
         }

         if(checkWheel(wheel) == true){

             System.out.println("Congrats! You Win!");
             displayWheel(wheel);

         }else{
             spinWheel(wheel, spins, reveals);
         }
         displayWheel(wheel); //For checking purposes, TAKE OUT LATER

    }

    public static boolean checkWheel(boolean[] array){

        for(int i = 1; i < array.length; i++){
            if(array[i] != array[0]){
                return false;
            }
        }
        return true;
    }

    public static void spinWheel(boolean[] array, int spins, int reveals){


    }

    //Converts boolean values on wheel to heads/tails
    private static void displayWheel(boolean[] array){

        System.out.println();
        System.out.println("Wheel State:");

        for(int i = 0; i < array.length; i++){

            if(array[i] == true){
                System.out.print("H ");

            }else{
                System.out.print("T ");
            }
        }

        System.out.println();
    }

    public static void main(String args[]){

        userInput(args);

    }
}
