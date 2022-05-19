package com.urise.webapp.model;

import java.util.List;

public class Organization {
    private final String name;
    private final String link;
    private final List<Participation> participations;

    public Organization(String name, String link, List<Participation> participations) {
        this.name = name;
        this.link = link;
        this.participations = participations;
    }

    public void print(){
        System.out.println("\n\t\t\t\t\t\t"+name+" "+link);
        for(Participation p : participations){
            p.print();
        }
    }
}
