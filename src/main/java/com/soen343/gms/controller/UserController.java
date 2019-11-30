package com.soen343.gms.controller;

import com.soen343.gms.model.Job;
import com.soen343.gms.model.JobState;
import com.soen343.gms.model.Task;
import com.soen343.gms.model.User;
import com.soen343.gms.service.JobService;
import com.soen343.gms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

    @RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();
        model.setViewName("user/login");
        return model;
    }

    @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("user", user);
        model.setViewName("user/signup");
        return model;
    }

    @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        User userExists = userService.findUserByUsername(user.getUsername());
        if(userExists != null) {
            bindingResult.rejectValue("username", "error.user", "Username has already been taken! Please try again");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("user/signup");
        } else {
            userService.saveUser(user);
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user", new User());
            model.setViewName("user/login");
        }
        return model;
    }

    @RequestMapping(value= {"/home/home"}, method=RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(auth.getName());
        model.addObject("username", user.getUsername());
        model.addObject("users", userService.findAll());
        model.setViewName("home/home");
        return model;
    }

    @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("error/access_denied");
        return model;
    }

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
        Job job = jobService.getJobById(id);
        model.setViewName("job/" + id);
        model.addObject("job", job);
        return model;
    }

    @RequestMapping(value={"/home/job/{id}/task"}, method=RequestMethod.GET)
    public ModelAndView taskpage(@PathVariable("id") long id){
        ModelAndView model = new ModelAndView();
        Job job = jobService.getJobById(id);
        List<Task> tasks = job.getTasks();
        model.setViewName("task/task" + id);
        model.addObject("tasks", tasks);
        return model;
    }



}