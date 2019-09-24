package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.StorageException;
import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    protected final static int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    @Override
    public Resume getResume(Object key) {
        int index = (Integer) key;
        return storage[index];
    }

    @Override
    public void saveResume(Object key, Resume resume) {
        int index = (Integer) key;
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertResume(resume, index);
            size++;
        }
    }

    @Override
    public void updateResume(Object key, Resume resume) {
        int index = (Integer) key;
        storage[index] = resume;
    }

    @Override
    public void deleteResume(Object key) {
        int index = (Integer) key;
        removeResume(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected boolean isExist(Object key) {
        int index = (Integer) key;
        return index >= 0;
    }

    protected abstract void insertResume(Resume resume, int index);

    protected abstract Integer findKey(String uuid);

    protected abstract void removeResume(int index);
}
