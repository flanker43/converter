package com.example.converter.dto;

public class ExchangeRatesXml {

    private Integer id;

    private String name;

    private String charCode;

    private double value;

    private int nominal;

    public ExchangeRatesXml(Integer id, String name, String charCode, double value, int nominal) {
        this.id = id;
        this.name = name;
        this.charCode = charCode;
        this.value = value;
        this.nominal = nominal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setValue(double value) {
        this.value = value;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }
}
