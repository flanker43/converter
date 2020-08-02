package com.example.converter.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExchangeRates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    private int numCode;

    private String name;

    private String charCode;

    private double value;

    private int nominal;

    public ExchangeRates(){}

    public ExchangeRates (Integer id, int numCode,  String name, String charCode, double value, int nominal){
        this.name = name;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumCode() {
        return numCode;
    }

    public void setNumCode(int numCode) {
        this.numCode = numCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public double getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }
}
