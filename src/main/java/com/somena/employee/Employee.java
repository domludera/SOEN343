package com.somena.employee;

import java.util.Date;

public class Employee {

    private long id;
    private Date startDate;
    private String firstName;
    private String lastName;


    public Employee(String firstName, String lastName, long id, Date startDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.startDate = startDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
