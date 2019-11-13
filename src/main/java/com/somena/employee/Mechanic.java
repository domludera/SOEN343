package com.somena.employee;

import com.somena.job.Job;

import java.util.Date;
import java.util.List;

public class Mechanic extends Employee{

    //mechanic has direct access to a list of Job objects which are ongoing an assigned to him
    private List<Job> jobList;

    public Mechanic(String firstName, String lastName, long id, Date startDate, List<Job> jobList) {
        super(firstName, lastName, id, startDate);
        this.jobList = jobList;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }
}
