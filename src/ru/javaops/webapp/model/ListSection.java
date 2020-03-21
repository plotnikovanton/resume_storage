package ru.javaops.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class ListSection extends Section {
    private List<String> items = new ArrayList<>();

    public List<String> getItems() {
        return items;
    }

    public void setItem(String item) {
        items.add(item);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String item : items) {
            s.append(item).append("\n");
        }
        return s.toString();
    }
}
