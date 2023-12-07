package com.example.springh2learner.Service;

import com.example.springh2learner.Entity.Learner;
import com.example.springh2learner.Repository.LearnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LearnerService {
    @Autowired
    LearnerRepo learnerRepo;

    //Create learner
    public Learner createLearner(Learner learner) {
        return learnerRepo.save(learner);
    }

    //get learner by id
    public Learner getLearnerById(int id) {
        return learnerRepo.findById(id).get();
    }

    //get all learners
    public List<Learner> getAllLearners() {
        return learnerRepo.findAll();
    }

    // get number of learners
    public int countLearners() {
        return learnerRepo.findAll().size();
    }

    //remove learner
    public void removeLearnerById(int id) {
        Optional<Learner> tempLearner = learnerRepo.findById(id);
        if(tempLearner.isEmpty()) {
            throw new RuntimeException("learner id" + id + "doesn't exist");
        }
        learnerRepo.deleteById(id);
    }

    // check if id exists
    public boolean CheckIdExists(int id) {
        Optional<Learner> tempLearner = learnerRepo.findById(id);
        return tempLearner.isPresent();
    }

    // get all learners by their last names case-insensitive
    public List<Learner> findByLastnameIgnoreCase(String lastname) {
        List<Learner> learnerlist = learnerRepo.findAll();
        List<Learner> resultlist = new ArrayList<>();
        for (Learner tempLearner : learnerlist) {
            if (Objects.equals(tempLearner.getLearner_last_name().toLowerCase(), lastname.toLowerCase()))
                resultlist.add(tempLearner);
        }
        return resultlist;
    }

}
