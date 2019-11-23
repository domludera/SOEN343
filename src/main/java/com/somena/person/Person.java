package com.somena.person;

import lombok.Data;

public @Data
class Person {


    private long id;
    private String firstName;
    private String lastName;


    public Person(String firstName, String lastName, long id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
}
