package com.carRental.tests;

import com.carRental.data.models.Booking;
import com.carRental.data.models.Car;
import com.carRental.data.models.CarCategory;
import com.carRental.data.models.RentalType;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BookingTest {

    @Test
    public void testBookingInitialization() {
        Car car = new Car("Toyota Corolla", CarCategory.ECONOMY, RentalType.DAILY);
        LocalDateTime rentalDate = LocalDateTime.now();
        LocalDateTime returnDate = rentalDate.plusDays(3);

        Booking booking = new Booking(1, car, "Justine Nnamdi", rentalDate, returnDate);

        assertEquals(1, booking.getBookingId());
        assertEquals(car, booking.getCar());
        assertEquals("Justine Nnamdi", booking.getCustomerName());
        assertEquals(rentalDate, booking.getRentalDate());
        assertEquals(returnDate, booking.getReturnDate());
    }

    @Test
    public void testBookingToString() {
        Car car = new Car("Honda Civic", CarCategory.SUV, RentalType.WEEKLY);
        LocalDateTime rentalDate = LocalDateTime.of(2025, 8, 10, 10, 0);
        LocalDateTime returnDate = rentalDate.of(2025, 8, 17, 10, 0);

        Booking booking = new Booking(2, car, "Esther Ben", rentalDate, returnDate);

        String expected = "Booking ID: 2, Car: " + car.getDescription()
                + ", Customer: Esther Ben, Rental Date: 2025-08-10T10:00, Return Date: 2025-08-17T10:00";
        assertEquals(expected, booking.toString());
    }

    @Test
    public void testBookingDateValidation() {
        Car car = new Car("BMW X5", CarCategory.LUXURY, RentalType.DAILY);
        LocalDateTime rentalDate = LocalDateTime.of(2025, 8, 10, 12, 0);
        LocalDateTime returnDate = rentalDate.of(2025, 8, 14, 12, 0);

        assertThrows(IllegalArgumentException.class, () -> new Booking(3, car, "Alice", returnDate , rentalDate));
    }
}
