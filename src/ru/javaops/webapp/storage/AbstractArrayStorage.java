package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.StorageException;
import ru.javaops.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    public Resume doGet(Object key) {
        int index = (Integer) key;
        return storage[index];
    }

    @Override
    public void doSave(Object key, Resume resume) {
        int index = (Integer) key;
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertResume(resume, index);
            size++;
        }
    }

    @Override
    public void doUpdate(Object key, Resume resume) {
        int index = (Integer) key;
        storage[index] = resume;
    }

    @Override
    public void doDelete(Object key) {
        int index = (Integer) key;
        removeResume(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> storageAsList = Arrays.asList(Arrays.copyOfRange(storage, 0, size));
        Collections.sort(storageAsList);
        return storageAsList;
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

    protected abstract Integer getSearchKey(String key);

    protected abstract void removeResume(int index);
}
