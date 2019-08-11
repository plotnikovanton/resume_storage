package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size == storage.length) {
            System.out.println("Storage is full");
        } else if (!(indexOf(resume.getUuid()) == -1)) {
            System.out.println("Resume already exists");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        int i = indexOf(uuid);
        if (i == -1) {
            System.out.println("No such resume");
            return null;
        } else {
            return storage[i];
        }
    }

    public void delete(String uuid) {
        int i = indexOf(uuid);
        if (i == -1) {
            System.out.println("No such resume");
        } else {
            System.arraycopy(storage, i + 1, storage, i, size - i - 1);
            storage[size - 1] = null;
            size--;
        }
    }

    public void update(Resume resume) {
        int i = indexOf(resume.getUuid());
        if ((i == -1)) {
            System.out.println("No such resume");
        } else {
            storage[i] = resume;
        }
    }

    private int indexOf(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
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
