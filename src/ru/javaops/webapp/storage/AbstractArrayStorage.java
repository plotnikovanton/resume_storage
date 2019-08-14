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
        int index = indexOf(uuid);
        if (index < 0) {
            System.out.println("No such resume");
            return null;
        }
        return storage[index];
    }

    public void save(Resume resume) {
        if (size == storage.length) {
            System.out.println("Storage is full");
        } else if (indexOf(resume.getUuid()) >= 0) {
            System.out.println("Resume already exists");
        } else {
            insertResume(resume);
            size++;
        }
    }

    public void update(Resume resume) {
        int index = indexOf(resume.getUuid());
        if (index < 0) {
            System.out.println("No such resume");
        } else {
            storage[index] = resume;
        }
    }

    public void delete(String uuid) {
        int index = indexOf(uuid);
        if (index < 0) {
            System.out.println("No such resume");
        } else {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
            storage[size - 1] = null;
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

    protected abstract void insertResume(Resume resume);

    protected abstract int indexOf(String uuid);
}
