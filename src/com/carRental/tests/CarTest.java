package com.carRental.tests;

import com.carRental.data.models.Car;
import com.carRental.data.models.CarCategory;
import com.carRental.data.models.Rentable;
import com.carRental.data.models.RentalType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {

    @Test
    public void testCarImplementsRentable() {
        Car car = new Car(1, "Toyota Corolla", CarCategory.ECONOMY, RentalType.DAILY);

        assertEquals("Toyota Corolla", car.getModel());
        assertEquals(CarCategory.ECONOMY, car.getCategory());
        assertEquals(RentalType.DAILY, car.getType());

        assertEquals(50.0, car.getPricePerDay(), 0.001);

        String expectedDescription = "Economy Toyota Corolla ($50.0 per day)";
        assertEquals(expectedDescription, car.getDescription());
    }

    @Test
    public void testCarToString() {
        Car car = new Car(1, "Range Rover", CarCategory.LUXURY, RentalType.MONTHLY);
        String expectedString = "Luxury Range Rover ($1000.0 per day)";
        assertEquals(expectedString, car.toString());
    }
}
