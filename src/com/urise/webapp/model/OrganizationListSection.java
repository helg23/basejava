package com.urise.webapp.model;

import java.util.List;

public class OrganizationListSection extends AbstractSection {
    private final List<Organization> organizations;

    public OrganizationListSection(String title, List<Organization> organizations) {
        super(title);
        this.organizations = organizations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        for (Organization o : organizations) {
            sb.append(o.toString()).append("\n");
        }
        return sb.toString();
    }

}
