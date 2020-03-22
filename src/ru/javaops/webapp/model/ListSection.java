package ru.javaops.webapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListSection extends Section {
    private final List<String> items;

    public ListSection() {
        items = new ArrayList<>();
    }

    public List<String> getItems() {
        return items;
    }

    public void setItem(String item) {
        items.add(item);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String item : items) {
            s.append(item).append("\n");
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}
