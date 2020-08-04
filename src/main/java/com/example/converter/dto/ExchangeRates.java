package com.example.converter.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ExchangeRates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String id;

    private int numCode;

    private String name;

    private String charCode;

    private double value;

    private int nominal;

    public ExchangeRates() {
    }

    public ExchangeRates(String id, int numCode, String charCode, int nominal, String name,  double value) {
        this.id = id;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }

    public String  getId() {
        return id;
    }

    public void setId(String  id) {
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

    public void setValue(double value) {
        this.value = value;
    }
}
