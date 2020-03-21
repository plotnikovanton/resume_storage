package ru.javaops.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class ExperienceSection extends Section {
    private List<Organization> organizations = new ArrayList<>();

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Organization organization) {
        organizations.add(organization);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Organization org : organizations) {
            s.append(org.toString()).append("\n");
        }
        return s.toString();
    }
}
