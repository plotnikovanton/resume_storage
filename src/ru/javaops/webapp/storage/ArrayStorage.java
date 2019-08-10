package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size == storage.length) {
            System.out.println("ArrayStorage is full");
        } else if (!isContained(resume)) {
            storage[size] = resume;
            size++;
        } else {
            System.out.println("Resume already exists");
        }
    }

    public Resume get(String uuid) {
        if (isContained(uuid)) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].getUuid())) {
                    return storage[i];
                }
            }
        }
        System.out.println("No such resume");
        return null;
    }

    public void delete(String uuid) {
        if (isContained(uuid)) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].getUuid())) {
                    System.arraycopy(storage, i + 1, storage, i, size - i - 1);
                    storage[size - i] = null;
                    size--;
                }
            }
        } else {
            System.out.println("No such resume");
        }
    }

    public void update(Resume resume) {
        if (isContained(resume)) {
            for (int i = 0; i < size; i++) {
                if (resume.equals(storage[i])) {
                    storage[i] = resume;
                    break;
                }
            }
        } else {
            System.out.println("No such resume");
        }
    }

    private boolean isContained(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (resume.equals(storage[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean isContained(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
