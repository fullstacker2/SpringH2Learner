package com.example.springh2learner.Controller;

import com.example.springh2learner.Entity.Learner;
import com.example.springh2learner.Service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learner")
public class LearnerController {
    @Autowired
    LearnerService learnerService;


    @PostMapping("/add")
    public Learner addLearner(@RequestBody Learner learner) {
        return learnerService.createLearner(learner);
    }

    @GetMapping("/{id}")
    public Learner getLearnerById(@PathVariable int id) {
        return learnerService.getLearnerById(id);
    }

    @GetMapping("/getAll")
    public List<Learner> getAllLearners() {
        return learnerService.getAllLearners();
    }

    @GetMapping("/count")
    public int countLearners() {
        return learnerService.countLearners();
    }

    @GetMapping("/del/{id}")
    public void removeLearnerById(@PathVariable int id) {
        learnerService.removeLearnerById(id);
    }

    @GetMapping("/check/{id}")
    public boolean CheckIdExists(@PathVariable int id) {
        return learnerService.CheckIdExists(id);
    }

    @GetMapping("/{lastname}")
    public List<Learner> findByLastnameIgnoreCase(@PathVariable String lastname) {
        return learnerService.findByLastnameIgnoreCase(lastname);
    }

}
