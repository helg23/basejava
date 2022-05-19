package com.urise.webapp.model;

import java.util.List;

public class ParticipationListSection extends AbstractSection{
    private final List<Organization> organizations;

    public ParticipationListSection(SectionType type,List<Organization> organizations) {
        super(type);
        this.organizations = organizations;
    }

    @Override
    protected void printContent() {
        for(Organization o : organizations){
            o.print();
        }
    }

}
