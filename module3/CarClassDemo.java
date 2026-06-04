public class CarClassDemo {
    public static void main(String[] args) {
        Car carOne = new Car("Toyota", "Corolla", 2022);
        Car carTwo = new Car("Honda", "City", 2021);

        carOne.displayDetails();
        carTwo.displayDetails();
    }
}

class Car {
    private final String make;
    private final String model;
    private final int year;

    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    void displayDetails() {
        System.out.println(make + " " + model + " " + year);
    }
}