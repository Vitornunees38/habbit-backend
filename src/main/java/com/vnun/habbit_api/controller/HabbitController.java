package com.vnun.habbit_api.controller;

import com.vnun.habbit_api.model.Habit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/habits")
@CrossOrigin(origins = "*")
public class HabbitController {

    private List<Habit> habits =  new ArrayList<>();


    @GetMapping
    public List<Habit> getAllHabits() {
        return habits;
    }

    @PostMapping
    public ResponseEntity<Habit> createHabit(@RequestBody Habit habit) {
        habit.setId((long) (habits.size() + 1));
        habits.add(habit);
        return ResponseEntity.ok(habit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabit(@PathVariable long id){
        habits.removeIf(h -> h.getId() == id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habit> updateHabit(@PathVariable Long id, @RequestBody Habit updatedHabit) {
        for (int i = 0; i < habits.size(); i++) {
            Habit habit = habits.get(i);

            if (habit.getId() == (id)) {
                updatedHabit.setId(id);
                habits.set(i, updatedHabit);
                return ResponseEntity.ok(updatedHabit);
            }
        }

        return ResponseEntity.notFound().build();
    }

}
