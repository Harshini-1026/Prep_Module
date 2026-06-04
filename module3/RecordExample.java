import java.util.List;

public class RecordExample {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Asha", 20),
                new Person("Ravi", 16),
                new Person("Meera", 24));

        people.stream()
                .filter(person -> person.age() >= 18)
                .forEach(System.out::println);
    }
}

record Person(String name, int age) {
}