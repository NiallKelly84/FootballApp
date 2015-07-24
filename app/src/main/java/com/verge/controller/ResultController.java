package com.verge.controller;

import com.verge.dto.ResultsInfo;
import com.verge.entity.Result;
import com.verge.repository.ResultRepository;
import com.verge.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("app/api/results")
public class ResultController {

    private static ResultRepository repository;

    private final String DRAW = "draw";

    @Autowired
    public void setResultRepository(ResultRepository repository) {
        ResultController.repository = repository;
    }

    @Autowired
    ResultService resultService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ResultsInfo>> getResultsByTeam(@RequestParam("teamA") String teamA, @RequestParam("teamB") String teamB) {
        List<ResultsInfo> results = resultService.getResults(teamA, teamB);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    public void saveResults(List<Result> results) {
        for (Result result : results) {
            String[] scores = result.getFullTime().split("-");
            int scoreTeamA = Integer.parseInt(scores[0]);
            int scoreTeamB = Integer.parseInt(scores[1]);
            if (scoreTeamA > scoreTeamB) {
                result.setMatchWinner(result.getTeamA());
            } else if (scoreTeamA < scoreTeamB) {
                result.setMatchWinner(result.getTeamB());
            } else{
                result.setMatchWinner(DRAW);
            }
        }
        repository.save(results);
    }
}
