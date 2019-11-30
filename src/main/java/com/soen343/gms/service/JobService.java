package com.soen343.gms.service;

import com.soen343.gms.model.Job;

import java.util.List;

public interface JobService
{
    void saveJob(Job job);
    List<Job> getAllJobs();
}
