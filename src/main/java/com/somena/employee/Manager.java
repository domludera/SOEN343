package com.somena.employee;

import java.util.Date;
import java.util.List;

public class Manager extends Employee{

    private List<Integer> jobList;

    public Manager(String firstName, String lastName, long id, Date startDate, List<Integer> jobList) {
        super(firstName, lastName, id, startDate);
        this.jobList = jobList;
    }

    public List<Integer> getJobList() {
        return jobList;
    }

    public void setJobList(List<Integer> jobList) {
        this.jobList = jobList;
    }
}
