package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.StorageException;
import ru.javaops.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
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
    protected boolean isExist(Integer index) {
        return index >= 0;
    }

    @Override
    public Resume doGet(Integer index) {
        return storage[index];
    }

    @Override
    public void doSave(Integer index, Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertResume(resume, index);
            size++;
        }
    }

    @Override
    public void doUpdate(Integer index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    public void doDelete(Integer index) {
        removeResume(index);
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
}
