package com.example.converter.repos;

import com.example.converter.dto.ExchangeRates;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRatesRepo extends CrudRepository<ExchangeRates, Integer> {
    List<ExchangeRates> findByName(String name);
}
