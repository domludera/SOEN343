package com.soen343.gms.service;

import com.soen343.gms.model.Job;
import com.soen343.gms.model.Task;
import com.soen343.gms.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("jobService")
public class JobServiceImplementation implements JobService {
    @Autowired
    JobRepository jobRepository;

    @Override
    public void saveJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job findJobById(long id) { return jobRepository.findJobById(id); }

    @Override
    public List<Task> findAllTask() {
        return null;
    }
}
