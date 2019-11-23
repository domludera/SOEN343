package com.somena.employee;

import com.somena.job.Job;
import lombok.Data;

import java.util.Date;
import java.util.List;

public @Data
class Mechanic extends Employee{

    //mechanic has direct access to a list of Job objects which are ongoing an assigned to him
    private List<Job> jobList;

    public Mechanic(String firstName, String lastName, long id, Date startDate, List<Job> jobList) {
        super(firstName, lastName, id, startDate);
        this.jobList = jobList;
    }

}
