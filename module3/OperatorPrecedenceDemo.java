public class OperatorPrecedenceDemo {
    public static void main(String[] args) {
        int resultOne = 10 + 5 * 2;
        int resultTwo = (10 + 5) * 2;
        int resultThree = 20 / 4 + 3 * 2;

        System.out.println("10 + 5 * 2 = " + resultOne);
        System.out.println("(10 + 5) * 2 = " + resultTwo);
        System.out.println("20 / 4 + 3 * 2 = " + resultThree);
    }
}