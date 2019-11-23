package com.somena.employee;

import lombok.Data;

import java.util.Date;
import java.util.List;

public @Data
class Manager extends Employee{

    //assuming jobs are ref by ID which is  Long
    private List<Long> jobList;

    public Manager(String firstName, String lastName, long id, Date startDate, List<Long> jobList) {
        super(firstName, lastName, id, startDate);
        this.jobList = jobList;
    }

}
