import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int secretNumber = random.nextInt(100) + 1;
        int guess;

        System.out.println("I picked a number between 1 and 100.");

        do {
            System.out.print("Guess the number: ");
            guess = scanner.nextInt();

            if (guess < secretNumber) {
                System.out.println("Too low.");
            } else if (guess > secretNumber) {
                System.out.println("Too high.");
            } else {
                System.out.println("Correct! You guessed it.");
            }
        } while (guess != secretNumber);

        scanner.close();
    }
}