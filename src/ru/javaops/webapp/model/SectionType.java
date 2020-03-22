package ru.javaops.webapp.model;

import java.util.Objects;

public enum SectionType {
    OBJECTIVE("Позиция"),
    PERSONAL("Личные качества"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Личные качества"),
    EDUCATION("Образование");

    private final String title;

    SectionType(String title) {
        Objects.requireNonNull(title, "Title must not be null");
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
