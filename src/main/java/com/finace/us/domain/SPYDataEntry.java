package com.finace.us.domain;

import lombok.Data;

@Data
public class SPYDataEntry {
    private String date;
    private double open;
    private double high;
    private double low;
    private double close;
    private int volume;
}