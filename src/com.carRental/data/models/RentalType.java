package com.carRental.data.models;

public enum RentalType {
    DAILY(50.0),
    WEEKLY(300.0),
    MONTHLY(1000.0);

    private final double pricePerDay;

    RentalType(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString(){
        return name() + " ($" + pricePerDay + " per day)";
    }
}
