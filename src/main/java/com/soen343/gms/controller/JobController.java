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
import java.util.ArrayList;
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

    @RequestMapping(value={"/home/job/{vin}"}, method=RequestMethod.GET)
    public ModelAndView jobpage(@PathVariable("vin") long vin){
        ModelAndView model = new ModelAndView();
        Job job = jobService.findJobsByVin(vin);
        model.setViewName("job/jobpage");
        model.addObject("job", job);
        return model;
    }

    @RequestMapping(value={"/home/job/{vin}/task"}, method=RequestMethod.GET)
    public ModelAndView taskpage(@PathVariable("vin") long vin){
        ModelAndView model = new ModelAndView();
        Job job = jobService.findJobsByVin(vin);
        List<Task> tasks = job.getTasks();
        model.setViewName("task/task");
        model.addObject("tasks", tasks);
        return model;
    }

    @RequestMapping(value = "/home/job/createjob", method= RequestMethod.POST)
    @ResponseBody
    public ModelAndView createJob(@RequestParam("vin") long vin, @RequestParam("notes") String notes, @RequestParam("customer") String customer, @RequestParam("task") String[] tasks) {
        ModelAndView model = new ModelAndView();
        Job job = new Job();
        job.setVin(vin);
        job.setDescription(notes);
        job.setState(JobState.Initial);
        job.setCustomer(customer);
        job.setMechanic("No Mechanic Assigned");

        ArrayList<Task> taskList = new ArrayList<Task>();
        for(String taskString: tasks){
            Task t = new Task();
            t.setTaskDescription(taskString);
            taskList.add(t);
        }

        job.setTasks(taskList);
        jobService.saveJob(job);
        model.setViewName("/job/createjob");
        return model;
    }






}
