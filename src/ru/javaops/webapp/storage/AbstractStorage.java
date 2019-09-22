package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.ExistStorageException;
import ru.javaops.webapp.exception.NotExistStorageException;
import ru.javaops.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {


    public Resume get(String uuid) {
        Object key = findKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(uuid);
    }

    public void save(Resume resume) {
        Object key = findKey(resume.getUuid());
        if (isExist(key)) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            saveResume(resume);
        }
    }

    public void update(Resume resume) {
        Object key = findKey(resume.getUuid());
        if (!isExist(key)) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            updateResume(resume);
        }
    }

    public void delete(String uuid) {
        Object key = findKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteResume(uuid);
        }
    }

    protected abstract Resume getResume(String uuid);

    protected abstract void saveResume(Resume resume);

    protected abstract void updateResume(Resume resume);

    protected abstract void deleteResume(String uuid);

    protected abstract boolean isExist(Object key);

    protected abstract Object findKey(String uuid);
}
