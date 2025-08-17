package com.carRental.data.models;

import java.time.LocalDateTime;

public class Booking {
    private int bookingID;
    private Car car;
    private String customerName;
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;

    public Booking(int bookingID, Car car, String customerName, LocalDateTime rentalDate, LocalDateTime returnDate) {
        if (returnDate != null && returnDate.isBefore(rentalDate)) {
            throw new IllegalArgumentException("Return Date cannot be before Return Date");
        }
        this.bookingID = bookingID;
        this.car = car;
        this.customerName = customerName;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }


    public int getBookingId() {
        return bookingID;
    }

    public Car getCar() {
        return car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public String toString(){
        return "Booking ID: " + bookingID +
                ", Car: " + car.getDescription() +
                ", Customer: " + customerName +
                ", Rental Date: " + rentalDate +
                ", Return Date: " + returnDate;
    }
}
