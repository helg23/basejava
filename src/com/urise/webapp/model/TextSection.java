package com.urise.webapp.model;

public class TextSection extends AbstractSection{
    private final String description;

    public TextSection(SectionType type,String description) {
        super(type);
        this.description = description;
    }

    @Override
    protected void printContent() {
        System.out.println(description);
    }
}
