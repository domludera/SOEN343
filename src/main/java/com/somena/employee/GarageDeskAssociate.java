package com.somena.employee;

import lombok.Data;

import java.util.Date;
import java.util.List;

public @Data
class GarageDeskAssociate extends Employee {


    //GDA hold a list of customers they are serving, which ref by ID (Long)
    private List<Long> customerList;

    public GarageDeskAssociate(String firstName, String lastName, long id, Date startDate, List<Long> customerList) {
        super(firstName, lastName, id, startDate);
        this.customerList = customerList;
    }

}
