package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.List;

public interface Storage {

    int size();

    Resume get(String uuid);

    void save(Resume resume);

    void update(Resume resume);

    void delete(String uuid);

    List<Resume> getAllSorted();

    void clear();
}
