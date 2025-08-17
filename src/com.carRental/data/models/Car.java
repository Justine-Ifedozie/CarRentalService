package com.carRental.data.models;

public class Car implements Rentable{
    private final int carID;
    private final String model;
    private final CarCategory category;
    private final RentalType type;

    public Car(int id, String model, CarCategory category, RentalType type) {
        this.carID = id;
        this.model = model;
        this.category = category;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public CarCategory getCategory() {
        return category;
    }

    public RentalType getType() {
        return type;
    }


    public double getPricePerDay(){
        return type.getPricePerDay();
    }


    public String getDescription(){
        return category + " " + model + " ($" + getPricePerDay() + " per day)";
    }

    @Override
    public String toString(){
        return getDescription();
    }

    public int getId() {
        return carID;
    }
}
