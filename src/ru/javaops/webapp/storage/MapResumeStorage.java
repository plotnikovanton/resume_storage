package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage<Resume> {

    private Map<String, Resume> mapResumeStorage = new HashMap<>();

    @Override
    protected Resume doGet(Resume key) {
        return key;
    }

    @Override
    protected void doSave(Resume key, Resume resume) {
        mapResumeStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doUpdate(Resume key, Resume resume) {
        mapResumeStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Resume key) {
        mapResumeStorage.remove(key.getUuid());
    }

    @Override
    protected boolean isExist(Resume key) {
        return key != null;
    }

    @Override
    protected Resume getSearchKey(String key) {
        Resume resume = mapResumeStorage.get(key);
        return mapResumeStorage.containsValue(resume) ? resume : null;
    }

    @Override
    public int size() {
        return mapResumeStorage.size();
    }

    @Override
    public List<Resume> doGetAllSorted() {
        return new ArrayList<>(mapResumeStorage.values());
    }

    @Override
    public void clear() {
        mapResumeStorage.clear();
    }
}
