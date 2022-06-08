package com.urise.webapp.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Position {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String position;
    private final String description;
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MM/yyyy");

    public Position(LocalDate startDate, LocalDate endDate, String position, String description) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.description = description;
    }

    public String toString() {
        String endDateString = endDate == null ? "Cейчас" : endDate.format(OUTPUT_FORMAT);
        StringBuilder sb = new StringBuilder("\n"+ startDate.format(OUTPUT_FORMAT) + " - " + endDateString);
        sb.append("\t\t").append(position);
        if (description!=null) sb.append("\n").append(description);
        return sb.toString();
    }
}
