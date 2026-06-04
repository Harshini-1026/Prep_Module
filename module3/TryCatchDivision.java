import java.util.Scanner;

public class TryCatchDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int first = scanner.nextInt();

        System.out.print("Enter second integer: ");
        int second = scanner.nextInt();

        try {
            System.out.println("Result: " + (first / second));
        } catch (ArithmeticException exception) {
            System.out.println("Cannot divide by zero.");
        }

        scanner.close();
    }
}