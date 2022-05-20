package com.urise.webapp.model;

import java.util.Locale;

public abstract class AbstractSection {

    protected String title;

    public AbstractSection(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return "\n==" + title.toUpperCase(Locale.ROOT) + "==\n";
    }
}
