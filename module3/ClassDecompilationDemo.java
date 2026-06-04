public class ClassDecompilationDemo {
    public static void main(String[] args) {
        ClassDecompilationDemo demo = new ClassDecompilationDemo();
        System.out.println(demo.message());
    }

    String message() {
        return "Compile this class and open the .class file in a decompiler.";
    }
}