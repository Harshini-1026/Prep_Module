public class JavapBytecodeInspection {
    public static void main(String[] args) {
        JavapBytecodeInspection demo = new JavapBytecodeInspection();
        System.out.println(demo.multiply(6, 7));
    }

    int multiply(int first, int second) {
        return first * second;
    }
}