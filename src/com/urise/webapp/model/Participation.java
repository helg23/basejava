package com.urise.webapp.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Participation {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String position;
    private final String description;
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MM/yyyy");

    public Participation(String startDate,String endDate,String position,String description){
        this.startDate = LocalDate.parse(startDate,INPUT_FORMAT);
        this.endDate = endDate.equals("") ? null : LocalDate.parse(endDate,INPUT_FORMAT);
        this.position = position;
        this.description = description;
    }

    public void print(){
        String endDateString = endDate == null ? "Cейчас" : endDate.format(OUTPUT_FORMAT);
        System.out.println(startDate.format(OUTPUT_FORMAT)+" - "+endDateString+"\t\t"+position);
    }
}
