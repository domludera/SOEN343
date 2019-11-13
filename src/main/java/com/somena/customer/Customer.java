package com.somena.customer;

import com.somena.person.Person;

import java.util.List;

public class Customer extends Person {

    private List<String> carVIN;

    public Customer(String firstName, String lastName, long id, List<String> carVIN) {
        super(firstName, lastName, id);
        this.carVIN = carVIN;
    }
}
