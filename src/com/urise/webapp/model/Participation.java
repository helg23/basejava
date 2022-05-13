package com.urise.webapp.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Participation {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String position;
    private final String description;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Participation(String startDate,String endDate,String position,String description){
        this.startDate = LocalDate.parse(startDate,formatter);
        this.endDate = endDate.equals("") ? null : LocalDate.parse(endDate,formatter);
        this.position = position;
        this.description = description;
    }

    public void print(){
        String endDateString = endDate == null ? "Cейчас" : endDate.toString();
        System.out.println(startDate+"-"+endDateString+"\t\t"+position);
        System.out.println(description+"\n");
    }
}
