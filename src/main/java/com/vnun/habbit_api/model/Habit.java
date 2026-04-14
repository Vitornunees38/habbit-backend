package com.vnun.habbit_api.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;


@Entity
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @ElementCollection
    private List<String> completedDates = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCompletedDates() {
        return completedDates;
    }

    public void setCompletedDates(List<String> completedDates) {
        this.completedDates = completedDates;
    }
}
