import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            Class<?> targetClass = Class.forName("DemoTarget");

            for (Method method : targetClass.getDeclaredMethods()) {
                System.out.print(method.getName() + "(");
                Parameter[] parameters = method.getParameters();
                for (int i = 0; i < parameters.length; i++) {
                    System.out.print(parameters[i].getType().getSimpleName());
                    if (i < parameters.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(")");
            }

            Object targetObject = targetClass.getDeclaredConstructor().newInstance();
            Method method = targetClass.getDeclaredMethod("sayHello", String.class);
            System.out.println(method.invoke(targetObject, "Student"));
        } catch (Exception exception) {
            System.out.println("Reflection error: " + exception.getMessage());
        }
    }
}

class DemoTarget {
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    public int add(int first, int second) {
        return first + second;
    }
}