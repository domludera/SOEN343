package com.soen343.gms.service;

import com.soen343.gms.model.Job;
import com.soen343.gms.model.Task;

import java.util.List;

public interface JobService
{
    void saveJob(Job job);
    List<Job> getAllJobs();
    Job getJobById(long id);
}
