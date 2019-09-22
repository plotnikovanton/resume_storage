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
    public Resume getResume(String uuid) {
        int index = findKey(uuid);
        return storage[index];
    }

    @Override
    public void saveResume(Resume resume) {
        int index = findKey(resume.getUuid());
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertResume(resume, index);
            size++;
        }
    }

    @Override
    public void updateResume(Resume resume) {
        int index = findKey(resume.getUuid());
        storage[index] = resume;
    }

    @Override
    public void deleteResume(String uuid) {
        int index = findKey(uuid);
        removeResume(index);
        storage[size - 1] = null;
        size--;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected boolean isExist(Object key) {
        if (findKey((String) (key)) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    protected abstract void insertResume(Resume resume, int index);

    protected abstract Integer findKey(String uuid);

    protected abstract void removeResume(int index);
}
