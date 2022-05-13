package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class TextListSection extends AbstractSection{
    private List<String> description = new ArrayList<>();

    public TextListSection(String name) {
        super(name);
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    @Override
    protected void printContent() {
        for(String s : description){
            System.out.println(" * "+s);
        }
    }
}
