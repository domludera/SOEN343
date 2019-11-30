package com.soen343.gms.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    private String description;
    private String mechanic;

    @Enumerated(EnumType.ORDINAL)
    private JobState state;

    @OneToMany(mappedBy = "job")
    private List<Task> tasks;

    @Enumerated(EnumType.STRING)
    public JobState getState() {
        return this.state;
    }
    public String toString() {

        String taskToString ="";
        for(int i = 0; i < tasks.size(); i++)
        {
            taskToString += tasks.get(i).toString() + "\n";
        }
        return "Job{" +
                "id=" + id +
                ", state=" + state +
                ", description='" + description + '\'' +
                ", mechanic='" + mechanic + '\'' +
                ", tasks=" + taskToString +
                '}';
    }
}
