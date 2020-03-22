package ru.javaops.webapp.model;

import java.util.Objects;

public enum ContactType {
    PHONENUMBER("Телефон"),
    SKYPE("Skype"),
    EMAIL("Почта"),
    LINKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STACKOVERFLOW("Профиль Stackoverflow"),
    WEBPAGE("Домашняя страница");

    private final String title;

    ContactType(String title) {
        Objects.requireNonNull(title, "Title must not be null");
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
