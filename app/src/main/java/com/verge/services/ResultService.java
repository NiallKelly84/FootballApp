package com.verge.services;

import com.verge.dto.ResultsInfo;
import com.verge.mappers.ResultsMapper;
import com.verge.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eniakel on 22/06/2015.
 */
@Service
public class ResultService {
    @Autowired
    private ResultsMapper mapper;

    @Autowired
    private ResultRepository repository;

    public List<ResultsInfo> getResults(String teamA, String teamB) {
        return mapper.map(repository.findAll(), new ResultsInfo(), teamA, teamB);
    }

}
