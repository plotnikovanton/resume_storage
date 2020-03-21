package ru.javaops.webapp.model;

import java.net.URL;
import java.time.LocalDate;

public class Organization {
    private String name;
    private URL link;
    private LocalDate dateOfEntering;
    private LocalDate dateOfLeaving;
    private String position;
    private String description;

    public Organization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public URL getLink() {
        return link;
    }

    public void setLink(URL link) {
        this.link = link;
    }

    public LocalDate getDateOfEntering() {
        return dateOfEntering;
    }

    public void setDateOfEntering(LocalDate dateOfEntering) {
        this.dateOfEntering = dateOfEntering;
    }

    public LocalDate getDateOfLeaving() {
        return dateOfLeaving;
    }

    public void setDateOfLeaving(LocalDate dateOfLeaving) {
        this.dateOfLeaving = dateOfLeaving;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name + "; " + link + "; " + dateOfEntering + "; " + dateOfLeaving + "; " +
                position + "; " + description;
    }
}
