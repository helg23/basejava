package com.urise.webapp.model;

import java.util.Objects;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private final String uuid;
    private final String fullName;

    public String getUuid() {
        return uuid;
    }

    public Resume(String fullName){
        this(UUID.randomUUID().toString(),fullName);
    }

    public Resume(String uuid,String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getFullName() {return fullName;}

    @Override
    public int compareTo(Resume o) {
        return uuid.compareTo(o.uuid);
    }

    @Override
    public String toString() {
        return uuid + "-" + fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resume)) return false;
        Resume resume = (Resume) o;
        return Objects.equals(getUuid(), resume.getUuid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
