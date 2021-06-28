package com.example.testhub.service;

import com.example.testhub.domain.Result;
import com.example.testhub.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ResultService {
    private ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<Result> findAll() {
        return this.resultRepository.findAll();
    }

    // Get all sorted results
    public List<Result> getAll() {
        List<Result> listOfResult = this.findAll();

        Collections.sort(listOfResult, (o1, o2) -> {
            if (o1.getTotalScore() > o2.getTotalScore())
                return -1;
            else if (o1.getTotalScore() < o2.getTotalScore())
                return 1;
            else
                return 0;
        });

        return listOfResult;
    }

    public Result addResult(Result result) {
        if (findByUsername(result.getUsername()) != null) {
            updateByUsername(
                    result.getUsername(),
                    result.getMathScore(),
                    result.getIqScore(),
                    result.getProgScore());

            return findByUsername(result.getUsername());
        }

        return this.resultRepository.save(result);
    }

    public Result findByUsername(String username) {
        return this.resultRepository.findByUsername(username);
    }

    public boolean updateByUsername(String username, Integer math_score, Integer iq_score, Integer prog_score) {
        Result resultFromDB = findByUsername(username);

        if (resultFromDB != null) {
            resultFromDB.setMathScore(math_score);
            resultFromDB.setIqScore(iq_score);
            resultFromDB.setProgScore(prog_score);

            return true;
        }

        return false;
    }
}
