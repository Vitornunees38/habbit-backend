package com.vnun.habbit_api.controller;

import com.vnun.habbit_api.model.Habit;
import com.vnun.habbit_api.repository.HabitRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/habits")
@CrossOrigin(origins = "*")


public class HabbitController {

    private List<Habit> habits =  new ArrayList<>();

    private final HabitRepository repository;

    public HabbitController(HabitRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public List<Habit> getAllHabits() {
        return repository.findAll();
    }

    @PostMapping
    public Habit createHabit(@RequestBody Habit habit) {
        return repository.save(habit);
    }

    @DeleteMapping("/{id}")
    public void deleteHabit(@PathVariable long id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Habit updateHabit(@PathVariable Long id, @RequestBody Habit updatedHabit) {
        return repository.findById(id)
                .map(habit -> {
                    habit.setName(updatedHabit.getName());
                    habit.setDescription(updatedHabit.getDescription());
                    habit.setCompletedDates(updatedHabit.getCompletedDates());
                    return repository.save(habit);
                })
                .orElseThrow(() -> new RuntimeException("Habit not found"));
    }

}
