package com.example.springh2learner.Repository;
import com.example.springh2learner.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {
}
