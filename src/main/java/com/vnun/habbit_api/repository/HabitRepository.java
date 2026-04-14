package com.vnun.habbit_api.repository;

import com.vnun.habbit_api.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit, Long> {

    
}
