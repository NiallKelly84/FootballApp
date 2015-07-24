package com.verge.repository;

import com.verge.entity.Result;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result, Long> {

    List<Result> findAll();

}
