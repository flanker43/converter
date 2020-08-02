package com.example.converter.repos;

import com.example.converter.dto.ChangeHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChangeHistoryRepo extends CrudRepository<ChangeHistory, Integer> {
    List<ChangeHistory> findByDate(double date);
}
