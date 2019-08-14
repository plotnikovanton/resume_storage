package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

public interface Storage {
    int size();

    Resume get(String uuid);

    void save(Resume r);

    void update(Resume r);

    void delete(String uuid);

    Resume[] getAll();

    void clear();
}
