package com.urise.webapp.model;

public class TextSection extends AbstractSection{
    private String description;

    public TextSection(String name) {
        super(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    protected void printContent() {
        System.out.println(description);
    }
}
