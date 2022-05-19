package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class TextListSection extends AbstractSection{
    private final List<String> bullets;

    public TextListSection(SectionType type,List<String> bullets) {
        super(type);
        this.bullets=bullets;
    }

    @Override
    protected void printContent() {
        for(String s : bullets){
            System.out.println(" * "+s);
        }
    }
}
