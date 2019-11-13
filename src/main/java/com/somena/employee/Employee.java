package com.somena.employee;

import com.somena.person.Person;

import java.util.Date;

public class Employee extends Person {

    private Date startDate;

    public Employee(String firstName, String lastName, long id, Date startDate) {
        super(firstName, lastName, id);
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
