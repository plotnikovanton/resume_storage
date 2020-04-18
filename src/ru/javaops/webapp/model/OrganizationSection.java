package ru.javaops.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrganizationSection extends Section {
    private static final long serialVersionUID = 1L;

    private final List<Organization> organizations;

    public OrganizationSection(Organization... organizations) {
        this(Arrays.asList(organizations));
    }

    public OrganizationSection(List<Organization> organizations) {
        Objects.requireNonNull(organizations, "organizations must not be null");
        this.organizations = organizations;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Organization organization) {
        organizations.add(organization);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Organization org : organizations) {
            sb.append(org.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return organizations != null ? organizations.equals(that.organizations) : that.organizations == null;
    }

    @Override
    public int hashCode() {
        return organizations != null ? organizations.hashCode() : 0;
    }
}
