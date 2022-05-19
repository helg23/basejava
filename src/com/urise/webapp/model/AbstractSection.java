package com.urise.webapp.model;

import java.util.Locale;

public abstract class AbstractSection {

    protected SectionType type;

    public AbstractSection(SectionType type) {
        this.type = type;
    }

    public SectionType getType() {
        return type;
    }

    protected void print(){
        System.out.println("\n=="+type.getTitle().toUpperCase(Locale.ROOT)+"==");
        printContent();
    }

    protected abstract void printContent();
}
