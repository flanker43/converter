package com.example.converter.controllers;

import com.example.converter.dto.ExchangeRates;
import com.example.converter.dto.ChangeHistory;

import com.example.converter.repos.ExchangeRatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {



    @Autowired
    private ExchangeRatesRepo exchangeRatesRepo;

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<ExchangeRates> exchangeRates = exchangeRatesRepo.findAll();
        model.put("exchangeRates", exchangeRates);
        return "main";
    }

    @PostMapping("from")
    public String from(@RequestParam String value, Map<String, Object> model) {
        Iterable<ExchangeRates> exchangeRates = exchangeRatesRepo.findByName(value);
        model.put("exchangeRates", exchangeRates);
        return "main";
    }

    @PostMapping("to")
    public String to(Map<String, Object> model) {
        Iterable<ExchangeRates> exchangeRates = exchangeRatesRepo.findAll();
        model.put("exchangeRates", exchangeRates);
        return "main";
    }
}
