package com.urise.webapp.model;

import java.util.List;

public class Organization {
    private final String name;
    private final List<Participation> participations;

    public Organization(String name, List<Participation> participations) {
        this.name = name;
        this.participations = participations;
    }

    public void print(){
        System.out.println("\t\t\t"+name);
        for(Participation p : participations){
            p.print();
        }
    }
}
