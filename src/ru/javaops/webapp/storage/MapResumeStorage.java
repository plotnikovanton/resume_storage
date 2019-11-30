package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {

    private Map<String, Resume> mapResumeStorage = new HashMap<>();

    @Override
    protected Resume doGet(Object key) {
        return (Resume) key;
    }

    @Override
    protected void doSave(Object key, Resume resume) {
        mapResumeStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doUpdate(Object key, Resume resume) {
        mapResumeStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Object key) {
        mapResumeStorage.remove(((Resume) key).getUuid());
    }

    @Override
    protected boolean isExist(Object key) {
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
    public List<Resume> getAllSorted() {
        List<Resume> resumes = new ArrayList<>(mapResumeStorage.values());
        Collections.sort(resumes);
        return resumes;
    }

    @Override
    public void clear() {
        mapResumeStorage.clear();
    }
}
