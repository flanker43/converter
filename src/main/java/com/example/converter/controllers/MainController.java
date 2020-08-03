package com.example.converter.controllers;

import com.example.converter.XMLService;
import com.example.converter.dto.ExchangeRates;
import com.example.converter.dto.ChangeHistory;

import com.example.converter.repos.ChangeHistoryRepo;
import com.example.converter.repos.ExchangeRatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    XMLService xmlService = new XMLService();

    @Autowired
    private ExchangeRatesRepo exchangeRatesRepo;
    private ChangeHistoryRepo changeHistory;

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        xmlService.parseXml();
        Iterable<ChangeHistory> changeHistories = changeHistory.findAll();
        model.put("history", changeHistories);
        return "main";
    }

    @PostMapping("from")
    public String from(@RequestParam String value, @RequestParam String text, Map<String, Object> model) {
        double result = Double.parseDouble(text) * Double.parseDouble(String.valueOf(exchangeRatesRepo.findByName(value)));
        Date date = new Date();
        ChangeHistory changeHistory = new ChangeHistory(date, Double.parseDouble(text), result, value, "₽");
        model.put("history", changeHistory);
        return "main";
    }

    @PostMapping("to")
    public String to(@RequestParam String value, @RequestParam String text1, Map<String, Object> model) {
        double result = Double.parseDouble(text1) * Double.parseDouble(String.valueOf(exchangeRatesRepo.findByName(value)));
        Date date = new Date();
        ChangeHistory changeHistory = new ChangeHistory(date, Double.parseDouble(text1), result, value, "₽");
        model.put("history", changeHistory);
        return "main";
    }
}
