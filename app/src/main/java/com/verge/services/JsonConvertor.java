package com.verge.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.verge.controller.ResultController;
import com.verge.entity.Result;

import java.io.File;
import java.util.List;

/**
 * Created by eniakel on 22/06/2015.
 */
public class JsonConvertor {

    public void createFields() {

        try {
            ObjectMapper mapper = new ObjectMapper();
            File jsonFile = new File("C:/Users/eniakel/MyProjects/FootballApp/app/src/main/resources/resultsData/results.json");
            List<Result> results = mapper.readValue(jsonFile, mapper.getTypeFactory().constructCollectionType(
                            List.class, Result.class));

            ResultController controller = new ResultController();
            controller.saveResults(results);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
