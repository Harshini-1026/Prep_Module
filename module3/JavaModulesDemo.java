public class JavaModulesDemo {
    public static void main(String[] args) {
        System.out.println(GreetingsModule.greet("Java Modules"));
    }
}

class GreetingsModule {
    static String greet(String name) {
        return UtilsModule.formatMessage(name);
    }
}

class UtilsModule {
    static String formatMessage(String name) {
        return "Hello from the utility layer, " + name + "!";
    }
}