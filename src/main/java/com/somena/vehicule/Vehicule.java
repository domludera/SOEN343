package com.somena.vehicule;

import com.somena.customer.Customer;

public class Vehicule {

    private Customer owner; // is owner long or Customer object?
    private String VIN;
    private String make;
    private int year;
    private int mileage; //in km

    public Vehicule(Customer owner, String VIN, String make, int year, int mileage) {
        this.owner = owner;
        this.VIN = VIN;
        this.make = make;
        this.year = year;
        this.mileage = mileage;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
