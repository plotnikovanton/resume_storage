package ru.javaops.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private final LocalDate dateOfEntering;
    private final LocalDate dateOfLeaving;
    private final String position;
    private final String description;

    public Organization(String name, String url, LocalDate dateOfEntering,
                        LocalDate dateOfLeaving, String position, String description) {
        Objects.requireNonNull(dateOfEntering, "Start date must not be null");
        Objects.requireNonNull(dateOfLeaving, "End date must not be null");
        Objects.requireNonNull(position, "Position must not be null");
        this.homePage = new Link(name, url);
        this.dateOfEntering = dateOfEntering;
        this.dateOfLeaving = dateOfLeaving;
        this.position = position;
        this.description = description;
    }

    public Link getHomePage() {
        return homePage;
    }

    public LocalDate getDateOfEntering() {
        return dateOfEntering;
    }

    public LocalDate getDateOfLeaving() {
        return dateOfLeaving;
    }

    public String getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homepage=" + homePage +
                ", dateOfEntering=" + dateOfEntering +
                ", dateOfLeaving=" + dateOfLeaving +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        if (!dateOfEntering.equals(that.dateOfEntering)) return false;
        if (!dateOfLeaving.equals(that.dateOfLeaving)) return false;
        if (!position.equals(that.position)) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + dateOfEntering.hashCode();
        result = 31 * result + dateOfLeaving.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
