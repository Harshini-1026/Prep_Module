public class PatternMatchingSwitchExample {
    public static void main(String[] args) {
        describeValue(42);
        describeValue("Core Java");
        describeValue(12.5);
        describeValue(true);
    }

    private static void describeValue(Object value) {
        String message = switch (value) {
            case Integer number -> "Integer value: " + number;
            case String text -> "String value: " + text;
            case Double amount -> "Double value: " + amount;
            case Boolean flag -> "Boolean value: " + flag;
            default -> "Unknown type: " + value;
        };

        System.out.println(message);
    }
}