package com.somena.person;

public class Person {


    private long id;
    private String firstName;
    private String lastName;


    public Person(String firstName, String lastName, long id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
