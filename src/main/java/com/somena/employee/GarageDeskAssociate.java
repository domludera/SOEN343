package com.somena.employee;

import java.util.Date;
import java.util.List;

public class GarageDeskAssociate extends Employee {

    private List<Integer> customerList;

    public GarageDeskAssociate(String firstName, String lastName, long id, Date startDate, List<Integer> customerList) {
        super(firstName, lastName, id, startDate);
        this.customerList = customerList;
    }

    public List<Integer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Integer> customerList) {
        this.customerList = customerList;
    }
}
