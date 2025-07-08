import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        String playAgain;

        do {
            int die1 = rand.nextInt(6) + 1;
            int die2 = rand.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.printf("You rolled %d + %d = %d%n", die1, die2, sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("You win.");
            } else {
                int point = sum;
                System.out.println("Point is set to " + point + ". Trying for point...");

                boolean keepRolling = true;
                while (keepRolling) {
                    die1 = rand.nextInt(6) + 1;
                    die2 = rand.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.printf("You rolled %d + %d = %d%n", point, sum, sum);

                    if (sum == point) {
                        System.out.println("You win!");
                        keepRolling = false;
                    } else if (sum == 7) {
                        System.out.println("Rolled a 7. You lose.");
                        keepRolling = false;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = input.nextLine().trim().toLowerCase();
        } while (playAgain.equalsIgnoreCase("y"));

        System.out.println("Thanks for playing!");
    }
}
