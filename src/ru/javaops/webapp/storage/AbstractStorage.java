package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.ExistStorageException;
import ru.javaops.webapp.exception.NotExistStorageException;
import ru.javaops.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected abstract Resume doGet(Object key);

    protected abstract void doSave(Object key, Resume resume);

    protected abstract void doUpdate(Object key, Resume resume);

    protected abstract void doDelete(Object key);

    protected abstract List<Resume> doGetAllSorted();

    protected abstract boolean isExist(Object key);

    protected abstract Object getSearchKey(String key);


    public Resume get(String uuid) {
        Object key = getExistedKey(uuid);
        return doGet(key);
    }

    public void save(Resume resume) {
        Object key = getNotExistedKey(resume.getUuid());
        doSave(key, resume);
    }

    public void update(Resume resume) {
        Object key = getExistedKey(resume.getUuid());
        doUpdate(key, resume);
    }

    public void delete(String uuid) {
        Object key = getExistedKey(uuid);
        doDelete(key);
    }

    public List<Resume> getAllSorted() {
        List<Resume> resumes = doGetAllSorted();
        Collections.sort(resumes);
        return resumes;
    }

    private Object getExistedKey(String uuid) {
        Object key = getSearchKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private Object getNotExistedKey(String uuid) {
        Object key = getSearchKey(uuid);
        if (isExist(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }
}
