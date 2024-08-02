package dev.julia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Cartest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("Toyota", 2021, 2.0, Car.FuelType.GASOLINE, Car.CarType.SUV, 4, 5, 180, Car.Color.BLUE, true);
    }

    @Test
    public void testGettersAndSetters() {
        car.setBrand("Honda");
        assertEquals("Honda", car.getBrand());

        car.setModelYear(2020);
        assertEquals(2020, car.getModelYear());

        car.setEngineVolume(1.8);
        assertEquals(1.8, car.getEngineVolume());

        car.setFuelType(Car.FuelType.DIESEL);
        assertEquals(Car.FuelType.DIESEL, car.getFuelType());

        car.setCarType(Car.CarType.COMPACT);
        assertEquals(Car.CarType.COMPACT, car.getCarType());

        car.setNumberOfDoors(2);
        assertEquals(2, car.getNumberOfDoors());

        car.setNumberOfSeats(4);
        assertEquals(4, car.getNumberOfSeats());

        car.setMaxSpeed(200);
        assertEquals(200, car.getMaxSpeed());

        car.setColor(Car.Color.RED);
        assertEquals(Car.Color.RED, car.getColor());

        car.setAutomatic(false);
        assertFalse(car.isAutomatic());
    }

    @Test
    public void testAccelerate() {
        car.accelerate(50);
        assertEquals(50, car.getCurrentSpeed());

        car.accelerate(150); // Exceeds max speed, should be set to max speed
        assertEquals(180, car.getCurrentSpeed());
        assertTrue(car.hasFines());
        assertEquals(100, car.getTotalFine()); // Assuming fine amount is 100
    }

    @Test
    public void testDecelerate() {
        car.accelerate(100);
        car.decelerate(50);
        assertEquals(50, car.getCurrentSpeed());

        car.decelerate(60); // Should not go below 0
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    public void testBrake() {
        car.accelerate(100);
        car.brake();
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    public void testCalculateArrivalTime() {
        car.accelerate(60);
        assertEquals(2, car.calculateArrivalTime(120));

        car.brake();
        assertEquals(Double.POSITIVE_INFINITY, car.calculateArrivalTime(120));
    }

    @Test
    public void testDisplayAttributes() {
        // Since this method prints to the console, we won't test it here.
        // However, in real scenarios, you might use a logging framework
        // and then capture and assert the log output.
    }

    @Test
    public void testHasFinesAndTotalFine() {
        assertFalse(car.hasFines());
        assertEquals(0, car.getTotalFine());

        car.accelerate(200); // Exceeds max speed, fine should be applied
        assertTrue(car.hasFines());
        assertEquals(100, car.getTotalFine());
    }
}
