package com.soen343.gms.controller;


import com.soen343.gms.model.Job;
import com.soen343.gms.model.JobState;
import com.soen343.gms.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private JobService jobService;

    @RequestMapping(value = "/home/job/create", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createJob(@RequestBody Job job) {
        job.setState(JobState.Initial);
        jobService.saveJob(job);
    }
}
