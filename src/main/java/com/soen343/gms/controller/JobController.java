package com.soen343.gms.controller;

import com.soen343.gms.model.Job;
import com.soen343.gms.model.JobState;
import com.soen343.gms.model.Task;
import com.soen343.gms.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping(value={"/home/job/createjob"}, method=RequestMethod.GET)
    public ModelAndView createjob(){
        ModelAndView model = new ModelAndView();
        model.setViewName("job/createjob");
        return model;
    }

    @RequestMapping(value = "/home/job/createjob", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createJob(@RequestBody Job job) {
        job.setState(JobState.Initial);
        jobService.saveJob(job);
    }


    @RequestMapping(value={"/home/job/checkout"}, method=RequestMethod.GET)
    public ModelAndView checkout(){
        ModelAndView model = new ModelAndView();
        model.setViewName("job/checkout");
        return model;
    }

    @RequestMapping(value={"/home/job/jobbank"}, method=RequestMethod.GET)
    public ModelAndView jobbank(){
        ModelAndView model = new ModelAndView();
        model.setViewName("job/jobbank");
        List<Job> job = jobService.getAllJobs();

        model.addObject("jobs", job);

        return model;
    }

    @RequestMapping(value={"/home/job/archivedjobs"}, method=RequestMethod.GET)
    public ModelAndView archivedjobs(){
        ModelAndView model = new ModelAndView();
        model.setViewName("job/archivedjob");
        return model;
    }

    @RequestMapping(value={"/home/job/{id}"}, method=RequestMethod.GET)
    public ModelAndView jobpage(@PathVariable("id") long id){
        ModelAndView model = new ModelAndView();
        Job job = jobService.findJobById(id);
        model.setViewName("job/jobpage");
        model.addObject("job", job);
        return model;
    }

    @RequestMapping(value={"/home/job/{id}/task"}, method=RequestMethod.GET)
    public ModelAndView taskpage(@PathVariable("id") long id){
        ModelAndView model = new ModelAndView();
        Job job = jobService.findJobById(id);
        List<Task> tasks = job.getTasks();
        model.setViewName("task/task");
        model.addObject("tasks", tasks);
        return model;
    }




}
