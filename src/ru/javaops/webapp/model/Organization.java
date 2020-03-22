package ru.javaops.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Organization {
    private final String name;
    private final String link;
    private final LocalDate dateOfEntering;
    private final LocalDate dateOfLeaving;
    private final String position;
    private final String description;

    public Organization(String name, String link, LocalDate dateOfEntering,
                        LocalDate dateOfLeaving, String position, String description) {
        Objects.requireNonNull(name, "Name must not be null");
        Objects.requireNonNull(link, "Link must not be null");
        Objects.requireNonNull(dateOfEntering, "Start date must not be null");
        Objects.requireNonNull(dateOfLeaving, "End date must not be null");
        Objects.requireNonNull(position, "Position must not be null");
        Objects.requireNonNull(description, "Description must not be null");
        this.name = name;
        this.link = link;
        this.dateOfEntering = dateOfEntering;
        this.dateOfLeaving = dateOfLeaving;
        this.position = position;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
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
        return name + "; " + link + "; " + dateOfEntering + "; " + dateOfLeaving + "; " +
                position + "; " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(link, that.link) &&
                Objects.equals(dateOfEntering, that.dateOfEntering) &&
                Objects.equals(dateOfLeaving, that.dateOfLeaving) &&
                Objects.equals(position, that.position) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, link, dateOfEntering, dateOfLeaving, position, description);
    }
}
