package ru.javaops.webapp.model;

import java.util.Arrays;
import java.util.List;

public class Organization {
    private final Link homePage;
    private List<Period> periods;

    public Organization(String name, String url, Period... periods) {
        this.homePage = new Link(name, url);
        this.periods = Arrays.asList(periods);
    }

    public Link getHomePage() {
        return homePage;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", periods=" + periods +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        return periods.equals(that.periods);
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + periods.hashCode();
        return result;
    }
}
