package com.urise.webapp.model;

import java.util.*;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    private final String uuid;
    private final String fullName;
    private EnumMap<ContactType,String> contacts;
    private EnumMap<SectionType,AbstractSection> sections;

    public Resume(String fullName){
        this(UUID.randomUUID().toString(),fullName);
    }

    public Resume(String uuid,String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
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

    public void setContacts(EnumMap<ContactType, String> contacts) {
        this.contacts = contacts;
    }

    public void setSections(EnumMap<SectionType, AbstractSection> sections) {
        this.sections = sections;
    }

    public void print(){
        System.out.println("==="+fullName.toUpperCase(Locale.ROOT)+"===");
        //for(Map.Entry<ContactType,String> contact : contacts.entrySet()){
        //    System.out.println(contact.getKey().getTitle()+": "+contact.getValue());
        //}
        for(Map.Entry<SectionType,AbstractSection> section : sections.entrySet()){
            section.getValue().print();
        }
    }
}
