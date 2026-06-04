import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaSortingExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Zara", "Amit", "Karan", "Bella"));

        Collections.sort(names, (first, second) -> first.compareToIgnoreCase(second));

        System.out.println(names);
    }
}