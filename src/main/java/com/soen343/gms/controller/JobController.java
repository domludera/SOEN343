package com.soen343.gms.controller;

import com.soen343.gms.model.Job;
import com.soen343.gms.model.JobState;
import com.soen343.gms.model.Task;
import com.soen343.gms.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping(value={"/home/job/createjob"}, method=RequestMethod.GET)
    public ModelAndView createjob(){
        ModelAndView model = new ModelAndView();
        model.setViewName("job/createjob");
        return model;
    }

    @RequestMapping(value={"/home/job/checkout"}, method=RequestMethod.GET)
    public ModelAndView checkout(){
        ModelAndView model = new ModelAndView();
        List<Job> completedJobs = jobService.findJobsByState(JobState.Complete);
        model.setViewName("job/checkout");
        return model;
    }

    @RequestMapping(value={"/home/job/jobbank"}, method=RequestMethod.GET)
    public ModelAndView jobbank(){
        ModelAndView model = new ModelAndView();
        model.setViewName("job/jobbank");
        List<Job> jobs = jobService.getAllJobs();
        model.addObject("jobs", jobs);
        return model;
    }

    @RequestMapping(value={"/home/job/archivedjobs"}, method=RequestMethod.GET)
    public ModelAndView archivedjobs(){
        ModelAndView model = new ModelAndView();
        List<Job> archivedJobs = jobService.findJobsByState(JobState.Archived);
        model.addObject("archivedJobs", archivedJobs);
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

    @RequestMapping(value = "/home/job/createjob", method= RequestMethod.POST)
    @ResponseBody
    public ModelAndView createJob(@RequestParam("vin") long vin, @RequestParam("notes") String notes) {
        ModelAndView model = new ModelAndView();
        Job job = new Job();
        job.setVin(vin);
        job.setDescription(notes);
        job.setState(JobState.Initial);
        jobService.saveJob(job);
        model.setViewName("/job/createjob");
        return model;
    }






}
