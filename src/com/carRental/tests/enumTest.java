package com.carRental.tests;

import com.carRental.data.models.CarCategory;
import com.carRental.data.models.RentalType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class enumTest {
    @Test
    public void testCarCategoryToString() {
        assertEquals("Economy", CarCategory.ECONOMY.toString());
        assertEquals("Suv", CarCategory.SUV.toString());
        assertEquals("Luxury", CarCategory.LUXURY.toString());
        assertEquals("Truck", CarCategory.TRUCK.toString());
    }

    @Test
    public void testRentalTypePriceAndToString() {
        assertEquals(50.0, RentalType.DAILY.getPricePerDay(), 0.001);
        assertEquals("DAILY ($50.0 per day)", RentalType.DAILY.toString());

        assertEquals(300.0, RentalType.WEEKLY.getPricePerDay(), 0.001);
        assertEquals("WEEKLY ($300.0 per day)", RentalType.WEEKLY.toString());

        assertEquals(1000.0, RentalType.MONTHLY.getPricePerDay(), 0.001);
        assertEquals("MONTHLY ($1000.0 per day)", RentalType.MONTHLY.toString());
    }
}
