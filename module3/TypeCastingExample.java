public class TypeCastingExample {
    public static void main(String[] args) {
        double decimalValue = 45.89;
        int wholeNumber = (int) decimalValue;

        int number = 32;
        double convertedValue = number;

        System.out.println("Double to int: " + wholeNumber);
        System.out.println("Int to double: " + convertedValue);
    }
}