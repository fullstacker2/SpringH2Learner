package com.example.springh2learner.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springh2learner.Entity.Learner;
public interface LearnerRepo extends JpaRepository<Learner, Integer> {
}
