package com.somena.employee;

import com.somena.person.Person;
import lombok.Data;

import java.util.Date;

public @Data class Employee extends Person {

    private Date startDate;

    public Employee(String firstName, String lastName, long id, Date startDate) {
        super(firstName, lastName, id);
        this.startDate = startDate;
    }
}
