package com.carRental.tests;

import com.carRental.data.models.*;
import org.junit.Test;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RentalServiceTest {

    @Test
    public void testAddCar() {
        RentalService rentalService = new RentalService();

        Car car = new Car(1, "Toyota Camry", CarCategory.ECONOMY, RentalType.DAILY);
        rentalService.addCar(car);

        List<Car> cars = rentalService.getCars();
        assertEquals(1, cars.size());
        assertEquals("Toyota Camry", cars.get(0).getModel());
    }

    @Test
    public void testBookCar() {
        RentalService rentalService = new RentalService();
        Car car = new Car(1, "Toyota Camry", CarCategory.ECONOMY, RentalType.DAILY);
        rentalService.addCar(car);

        Booking booking = rentalService.bookCar(1, "John", RentalType.DAILY);

        assertNotNull(booking);
        assertEquals(1, booking.getCar().getId());
        assertEquals("John", booking.getCustomerName());
        assertEquals(RentalType.DAILY, booking.getCar().getType());
        assertTrue(booking.getRentalDate().isBefore(LocalDateTime.now().plusSeconds(1)));
    }

    @Test
    public void deleteBooking() {
        RentalService rentalService = new RentalService();

        Car car = new Car(1, "Toyota Camry", CarCategory.ECONOMY, RentalType.DAILY);
        rentalService.addCar(car);

        Booking booking = rentalService.bookCar(1, "John", RentalType.DAILY);
        assertNotNull(booking);
        int bookingID = booking.getBookingId();

        boolean deleted = rentalService.deleteBooking(bookingID);
        assertTrue(deleted);
        assertTrue(rentalService.getBookings().isEmpty());
    }

    @Test
    public void testListAvailableCars() {
        RentalService rentalService = new RentalService();

        Car car1 = new Car(1, "Toyota Camry", CarCategory.ECONOMY, RentalType.DAILY);
        Car car2 = new Car(2, "BMW X5", CarCategory.LUXURY, RentalType.WEEKLY);
        rentalService.addCar(car1);
        rentalService.addCar(car2);

        List<Car> availableCars = rentalService.listAvailableCars();
        assertTrue(availableCars.contains(car1));
        assertTrue(availableCars.contains(car2));

        rentalService.bookCar(1, "John", RentalType.DAILY);

        availableCars = rentalService.listAvailableCars();
        assertFalse(availableCars.contains(car1));
        assertTrue(availableCars.contains(car2));
    }
}
