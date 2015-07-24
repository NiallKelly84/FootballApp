package com.verge.mappers;

import com.verge.dto.ResultsInfo;
import com.verge.entity.Result;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eniakel on 22/06/2015.
 */
@Controller
public class ResultsMapper {
    public List<ResultsInfo> map(List<Result> results, ResultsInfo resultsInfo, String team1, String team2) {
        List<ResultsInfo> resultsInfoList = new ArrayList<>();

        for (Result result : results) {
            if (((result.getTeamA().equals(team1) &&  result.getTeamB().equals(team2)) ||
                    (result.getTeamB().equals(team1) &&  result.getTeamA().equals(team2)))) {
                resultsInfo.setId(result.getId());
                resultsInfo.setMatchDate(result.getMatchDate());
                resultsInfo.setTeamA(result.getTeamA());
                resultsInfo.setTeamB(result.getTeamB());
                resultsInfo.setHalfTime(result.getHalfTime());
                resultsInfo.setFullTime(result.getFullTime());
                resultsInfoList.add(resultsInfo);
            }
        }
        return resultsInfoList;
    }
}
