package com.example.converter.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ChangeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    private Date date;

    private double userSum;

    private double complSum;

    private String charCodeBefore;

    private String charCodeAfter;

    public ChangeHistory() {
    }

    public ChangeHistory(Date date, double userSum, double complSum, String charCodeBefore, String charCodeAfter) {
        this.date = date;
        this.userSum = userSum;
        this.complSum = complSum;
        this.charCodeBefore = charCodeBefore;
        this.charCodeAfter = charCodeAfter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getUserSum() {
        return userSum;
    }

    public void setUserSum(long userSum) {
        this.userSum = userSum;
    }

    public double getComplSum() {
        return complSum;
    }

    public void setComplSum(long complSum) {
        this.complSum = complSum;
    }

    public String getCharCodeBefore() {
        return charCodeBefore;
    }

    public void setCharCodeBefore(String charCodeBefore) {
        this.charCodeBefore = charCodeBefore;
    }

    public String getCharCodeAfter() {
        return charCodeAfter;
    }

    public void setCharCodeAfter(String charCodeAfter) {
        this.charCodeAfter = charCodeAfter;
    }
}
