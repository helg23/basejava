package com.urise.webapp.model;

import java.util.*;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    private final String uuid;
    private final String fullName;
    private Map<ContactType, String> contacts;
    private Map<SectionType, AbstractSection> sections;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public int compareTo(Resume o) {
        return uuid.compareTo(o.uuid);
    }

    public void setContacts(EnumMap<ContactType, String> contacts) {
        this.contacts = contacts;
    }

    public void setSections(EnumMap<SectionType, AbstractSection> sections) {
        this.sections = sections;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("===" + fullName.toUpperCase(Locale.ROOT) + "===");
        if (contacts != null) {
            for (Map.Entry<ContactType, String> contact : contacts.entrySet()) {
                sb.append("\n").append(contact.getKey().getTitle()).append(": ").append(contact.getValue());
            }
        }
        sb.append("\n");
        for (Map.Entry<SectionType, AbstractSection> section : sections.entrySet()) {
            sb.append(section.getValue());
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) && Objects.equals(fullName, resume.fullName) && Objects.equals(contacts, resume.contacts) && Objects.equals(sections, resume.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, contacts, sections);
    }

    public enum ContactType {
        PHONE("Тел."),
        SKYPE("Skype"),
        EMAIL("Email"),
        LINKEDIN("LinkedIn"),
        GITHUB("GitHub"),
        STACKOVERFLOW("Stack Overflow"),
        HOMEPAGE("Личная страница");

        private final String title;

        ContactType(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public enum SectionType {
        PERSONAL("Личные качества"),
        OBJECTIVE("Позиция"),
        ACHIEVEMENT("Достижения"),
        QUALIFICATIONS("Квалификация"),
        EXPERIENCE("Опыт работы"),
        EDUCATION("Образование");

        private final String title;

        SectionType(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
}
