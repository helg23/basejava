package com.urise.webapp.model;

public class TextSection extends AbstractSection {
    private final String description;

    public TextSection(String title, String description) {
        super(title);
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString() + description + "\n";
    }
}
