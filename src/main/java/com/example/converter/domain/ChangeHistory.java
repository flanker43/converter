package com.example.converter.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChangeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    private long date;

    private long userSum;

    private long complSum;

    private String charCodeBefore;

    private String charCodeAfter;

    public ChangeHistory() {
    }

    public ChangeHistory(long date, long userSum, long complSum, String charCodeBefore, String charCodeAfter) {
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getUserSum() {
        return userSum;
    }

    public void setUserSum(long userSum) {
        this.userSum = userSum;
    }

    public long getComplSum() {
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
