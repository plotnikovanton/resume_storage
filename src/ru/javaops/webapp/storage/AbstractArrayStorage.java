package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.StorageException;
import ru.javaops.webapp.model.Resume;

import java.util.Arrays;
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

    protected abstract void insertResume(Resume resume, int index);

    protected abstract Integer getSearchKey(String key);

    protected abstract void removeResume(int index);

    @Override
    public Resume doGet(Object index) {
        return storage[(int) index];
    }

    @Override
    public void doSave(Object index, Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertResume(resume, (int) index);
            size++;
        }
    }

    @Override
    public void doUpdate(Object index, Resume resume) {
        storage[(int) index] = resume;
    }

    @Override
    public void doDelete(Object index) {
        removeResume((int) index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public List<Resume> doGetAllSorted() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected boolean isExist(Object index) {
        return (int) index >= 0;
    }
}
