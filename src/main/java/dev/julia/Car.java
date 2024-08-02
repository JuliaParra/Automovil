package dev.julia;

public class Car {
    // Enum for Fuel Type
    public enum FuelType {
        GASOLINE, BIOETHANOL, DIESEL, BIODIESEL, NATURAL_GAS
    }

    // Enum for Car Type
    public enum CarType {
        CITY_CAR, SUBCOMPACT, COMPACT, FAMILY, EXECUTIVE, SUV
    }

    // Enum for Color
    public enum Color {
        WHITE, BLACK, RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET
    }

    // Attributes
    private String brand;
    private int modelYear;
    private double engineVolume;
    private FuelType fuelType;
    private CarType carType;
    private int numberOfDoors;
    private int numberOfSeats;
    private double maxSpeed;
    private Color color;
    private double currentSpeed;
    private boolean isAutomatic;
    private int fineCount;
    private double totalFine;

    // Constructor
    public Car(String brand, int modelYear, double engineVolume, FuelType fuelType, CarType carType,
               int numberOfDoors, int numberOfSeats, double maxSpeed, Color color, boolean isAutomatic) {
        this.brand = brand;
        this.modelYear = modelYear;
        this.engineVolume = engineVolume;
        this.fuelType = fuelType;
        this.carType = carType;
        this.numberOfDoors = numberOfDoors;
        this.numberOfSeats = numberOfSeats;
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.currentSpeed = 0;
        this.isAutomatic = isAutomatic;
        this.fineCount = 0;
        this.totalFine = 0;
    }

    // Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean isAutomatic) {
        this.isAutomatic = isAutomatic;
    }

    // Methods
    public void accelerate(double increment) {
        if (currentSpeed + increment > maxSpeed) {
            System.out.println("Warning: Speed exceeds the maximum limit! Fine applied.");
            fineCount++;
            totalFine += 100; // Assuming the fine amount is 100
            currentSpeed = maxSpeed;
        } else {
            currentSpeed += increment;
        }
        System.out.println("Current speed: " + currentSpeed + " km/h");
    }

    public void decelerate(double decrement) {
        if (currentSpeed - decrement < 0) {
            System.out.println("Warning: Speed cannot be negative!");
            currentSpeed = 0;
        } else {
            currentSpeed -= decrement;
        }
        System.out.println("Current speed: " + currentSpeed + " km/h");
    }

    public void brake() {
        currentSpeed = 0;
        System.out.println("The car has stopped. Current speed: " + currentSpeed + " km/h");
    }

    public double calculateArrivalTime(double distance) {
        if (currentSpeed == 0) {
            System.out.println("The car is not moving.");
            return Double.POSITIVE_INFINITY; // Representing an infinite time because the car is not moving
        }
        return distance / currentSpeed;
    }

    public void displayAttributes() {
        System.out.println("Brand: " + brand);
        System.out.println("Model Year: " + modelYear);
        System.out.println("Engine Volume: " + engineVolume + " liters");
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Car Type: " + carType);
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Number of Seats: " + numberOfSeats);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Color: " + color);
        System.out.println("Current Speed: " + currentSpeed + " km/h");
        System.out.println("Automatic: " + (isAutomatic ? "Yes" : "No"));
    }

    public boolean hasFines() {
        return fineCount > 0;
    }

    public double getTotalFine() {
        return totalFine;
    }

    // Main Method for Testing
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 2021, 2.0, FuelType.GASOLINE, CarType.SUV, 4, 5, 180, Color.BLUE, true);

        myCar.displayAttributes();
        myCar.accelerate(100);
        myCar.accelerate(20);
        myCar.decelerate(50);
        myCar.brake();
        
        if (myCar.hasFines()) {
            System.out.println("The car has fines. Total fine amount: $" + myCar.getTotalFine());
        } else {
            System.out.println("The car has no fines.");
        }
    }
}