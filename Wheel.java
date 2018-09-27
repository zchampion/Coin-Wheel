import java.util.*;

public class Wheel {
    private static int coins, reveals, spins;
    private static boolean[] wheel;

    /*
     * Builds the wheel object.
     * Asks
     */
    Wheel (int coins, int reveals, int spins) {

        Random random = new Random();

        this.coins = coins;
        this.reveals = reveals;
        this.spins = spins;
        this.wheel = new boolean[coins];

        for (int i = 0; i < coins; i++)
            this.wheel[i] = random.nextBoolean();
    }

    /*
     * Returns a displayable representation of the wheel object.
     */
    public String toString() {

        String wheel_str = "Wheel state:\n[";

        for (int coin = 0; coin < this.wheel.length - 1; coin++) {
            wheel_str += this.wheel[coin] ? "H " : "T ";
        }

        wheel_str += this.wheel[this.wheel.length - 1] ? "H" : "T";

        wheel_str += "]";

        return wheel_str;
    }

    /*
     * Generate random covered coins in the game
     * Print the wheel that user sees
    */
    public void userWheel(int coins, int reveals) {

        Random random = new Random();
        int temp = 0;
        int hide = coins - reveals;

        List<Integer> list = new ArrayList<Integer>();
        // Generating random indexes
        for (int i = 1; i <= hide; i++) {
            temp = random.nextInt(this.wheel.length);
            if (!(list.contains(temp))) {
                list.add(temp);
            }
            else {   i--;
            }
        }
        System.out.println();
        System.out.println("The wheel that user sees:");

        for (int j = 0; j < this.wheel.length; j++) {

            if (list.contains(j)) {
                System.out.print("_ ");
            } else if (this.wheel[j] == false) {
                System.out.print("T ");
            } else if (this.wheel[j] == true) {
                System.out.print("H ");

            }
        }
    }

    /*
     * Checks the win conditions of the game.
     * Returns true if the win condtions are met
     * and false if they are not.
     */
    public boolean checkWheel() {
        
        for(int coin = 1; coin < this.wheel.length; coin++)
            if(this.wheel[coin] != this.wheel[0])
                return false;
        
        return true;
    }

    public static void spinWheel(boolean[] array, int spins, int reveals){}
}