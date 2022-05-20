package com.urise.webapp.model;

import java.util.List;

public class Organization {
    private final String name;
    private final String link;
    private final List<Position> positions;

    public Organization(String name, String link, List<Position> positions) {
        this.name = name;
        this.link = link;
        this.positions = positions;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\n\t\t\t\t\t\t" + name + " " + link);
        for (Position p : positions) {
            sb.append(p.toString());
        }
        return sb.toString();
    }
}
