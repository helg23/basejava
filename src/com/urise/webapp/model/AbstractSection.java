package com.urise.webapp.model;

import java.util.Locale;

public abstract class AbstractSection {
    protected String name;

    public AbstractSection(String name) {
        this.name = name;
    }

    protected void print(){
        System.out.println("\n\n"+name.toUpperCase(Locale.ROOT)+"\n");
        printContent();
    }

    protected abstract void printContent();
}
