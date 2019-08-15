package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {

    protected final static int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = indexOfResume(uuid);
        if (index < 0) {
            System.out.println("No such resume");
            return null;
        }
        return storage[index];
    }

    public void save(Resume resume) {
        int index = indexOfResume(resume.getUuid());
        if (size == STORAGE_LIMIT) {
            System.out.println("Storage is full");
        } else if (index >= 0) {
            System.out.println("Resume already exists");
        } else {
            insertResume(resume, index);
            size++;
        }
    }

    public void update(Resume resume) {
        int index = indexOfResume(resume.getUuid());
        if (index < 0) {
            System.out.println("No such resume");
        } else {
            storage[index] = resume;
        }
    }

    public void delete(String uuid) {
        int index = indexOfResume(uuid);
        if (index < 0) {
            System.out.println("No such resume");
        } else {
            removeResume(index);
            size--;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    protected abstract void insertResume(Resume resume, int index);

    protected abstract int indexOfResume(String uuid);

    protected abstract void removeResume(int index);
}
