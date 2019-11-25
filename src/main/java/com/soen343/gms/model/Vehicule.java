package com.soen343.gms.model;

import lombok.Data;

public @Data
class Vehicule {

    private long ownerId; // is owner long or Customer object?
    private String VIN;
    private String make;
    private int year;
    private int mileage; //in km

    public Vehicule(long ownerId, String VIN, String make, int year, int mileage) {
        this.ownerId = ownerId;
        this.VIN = VIN;
        this.make = make;
        this.year = year;
        this.mileage = mileage;
    }

}
