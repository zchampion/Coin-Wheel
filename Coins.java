import java.util.*;

public class Coins {

    public static void userInput(){

        Scanner in = new Scanner(System.in);

        System.out.println("How many coins in play?: ");
        int coins = in.nextInt();

        System.out.println("How many do you wish to reveal each turn?: ");
        int reveals = in.nextInt();

        System.out.println("How many spins?: ");
        int spins = in.nextInt();

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

        for(int i = 0; i < array.length; i++){

            if(array[i] == true){
                System.out.print("H ");

            }else{
                System.out.print("T ");
            }
        }

    }

    public static void main(String args[]){

        userInput();

    }
}
