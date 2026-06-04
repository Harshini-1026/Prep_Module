public class MethodOverloadingDemo {
    public static void main(String[] args) {
        System.out.println("Sum of two ints: " + add(10, 20));
        System.out.println("Sum of two doubles: " + add(12.5, 7.25));
        System.out.println("Sum of three ints: " + add(1, 2, 3));
    }

    static int add(int first, int second) {
        return first + second;
    }

    static double add(double first, double second) {
        return first + second;
    }

    static int add(int first, int second, int third) {
        return first + second + third;
    }
}