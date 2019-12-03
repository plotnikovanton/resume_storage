package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.ExistStorageException;
import ru.javaops.webapp.exception.NotExistStorageException;
import ru.javaops.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {

    protected abstract SK getSearchKey(String key);

    protected abstract boolean isExist(SK key);

    protected abstract Resume doGet(SK key);

    protected abstract void doSave(SK key, Resume resume);

    protected abstract void doUpdate(SK key, Resume resume);

    protected abstract void doDelete(SK key);

    protected abstract List<Resume> doGetAllSorted();


    public Resume get(String uuid) {
        SK key = getExistedKey(uuid);
        return doGet(key);
    }

    public void save(Resume resume) {
        SK key = getNotExistedKey(resume.getUuid());
        doSave(key, resume);
    }

    public void update(Resume resume) {
        SK key = getExistedKey(resume.getUuid());
        doUpdate(key, resume);
    }

    public void delete(String uuid) {
        SK key = getExistedKey(uuid);
        doDelete(key);
    }

    public List<Resume> getAllSorted() {
        List<Resume> resumes = doGetAllSorted();
        Collections.sort(resumes);
        return resumes;
    }

    private SK getExistedKey(String uuid) {
        SK key = getSearchKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private SK getNotExistedKey(String uuid) {
        SK key = getSearchKey(uuid);
        if (isExist(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }
}
