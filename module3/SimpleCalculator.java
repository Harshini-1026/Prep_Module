import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double firstNumber = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double secondNumber = scanner.nextDouble();

        System.out.print("Choose operation (+, -, *, /): ");
        String operation = scanner.next();

        double result;

        switch (operation) {
            case "+":
                result = firstNumber + secondNumber;
                System.out.println("Result: " + result);
                break;
            case "-":
                result = firstNumber - secondNumber;
                System.out.println("Result: " + result);
                break;
            case "*":
                result = firstNumber * secondNumber;
                System.out.println("Result: " + result);
                break;
            case "/":
                if (secondNumber == 0) {
                    System.out.println("Division by zero is not allowed.");
                } else {
                    result = firstNumber / secondNumber;
                    System.out.println("Result: " + result);
                }
                break;
            default:
                System.out.println("Invalid operation.");
        }

        scanner.close();
    }
}