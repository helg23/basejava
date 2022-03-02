package com.urise.webapp.model;

import java.util.Objects;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private final String uuid;

    public String getUuid() {
        return uuid;
    }

    public Resume(){
        this(UUID.randomUUID().toString());
    }

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public int compareTo(Resume o) {
        return uuid.compareTo(o.uuid);
    }

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resume)) return false;
        Resume resume = (Resume) o;
        return Objects.equals(getUuid(), resume.getUuid());
    }
}
