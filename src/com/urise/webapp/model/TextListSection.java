package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class TextListSection extends AbstractSection {
    private final List<String> bullets;

    public TextListSection(String title, List<String> bullets) {
        super(title);
        this.bullets = bullets;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        for (String s : bullets) {
            sb.append(" * ").append(s).append("\n");
        }
        return sb.toString();
    }
}
