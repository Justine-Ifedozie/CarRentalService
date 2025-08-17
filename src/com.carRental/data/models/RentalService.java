package com.carRental.data.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.carRental.data.models.*;

public class RentalService {
    private final List<Car> cars;
    private final List<Booking> bookings;
    private int nextBookingId;

    public RentalService() {
        this.cars = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Booking bookCar(int carId, String customerName, RentalType Type) {
        for (Car car : cars) {
            if(car.getId() == carId){
                Booking booking = new Booking(nextBookingId++, car, customerName, LocalDateTime.now(), null);
                bookings.add(booking);
                return booking;
            }
        }
        return null;
    }

    public boolean deleteBooking(int bookingID) {
        for (Booking booking : bookings) {
            if(booking.getBookingId() == bookingID){
                bookings.remove(booking);
                return true;
            }
        }
        return false;
    }


    public List getBookings() {
        return bookings;
    }

    public List<Car> listAvailableCars() {
        return cars;
    }
}
