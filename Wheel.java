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

        if (this.checkWheel()) {
            System.out.println("Congrats! You Win!");
        }
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
     * Checks the win conditions of the game.
     * Returns true if the win condtions are met
     * and false if they are not.
     */
    private boolean checkWheel() {
        
        for(int coin = 1; coin < this.wheel.length; coin++)
            if(this.wheel[coin] != this.wheel[0])
                return false;
        
        return true;
    }

    public static void spinWheel(boolean[] array, int spins, int reveals){}
}