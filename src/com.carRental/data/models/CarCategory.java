package com.carRental.data.models;

public enum CarCategory {
    ECONOMY("Economy"), SUV("Suv"), LUXURY("Luxury"), TRUCK("Truck");

    private final String displayName;
    CarCategory(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
