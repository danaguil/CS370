// Step 1: Define the class
class Car {
    // Step 2: Define attributes (fields)
    private String make;
    private String model;
    private int year;
    private String color;

    // Step 3: Constructor to initialize the car's attributes
    public Car(String make, String model, int year, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    // Step 4: Method to display car details
    public void displayCarDetails() {
        System.out.println("Car Make: " + make);
        System.out.println("Car Model: " + model);
        System.out.println("Car Year: " + year);
        System.out.println("Car Color: " + color);
    }

    // Step 5: Method to start the car
    public void startCar() {
        System.out.println("The " + make + " " + model + " is now starting...");
    }
}

