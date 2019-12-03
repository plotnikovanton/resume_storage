package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {

    private Map<String, Resume> mapUuidStorage = new HashMap<>();

    @Override
    protected Resume doGet(String key) {
        return mapUuidStorage.get(key);
    }

    @Override
    protected void doSave(String key, Resume resume) {
        mapUuidStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doUpdate(String key, Resume resume) {
        mapUuidStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(String key) {
        mapUuidStorage.remove(key);
    }

    @Override
    protected boolean isExist(String key) {
        return key != null;
    }

    @Override
    protected String getSearchKey(String uuid) {
        return mapUuidStorage.containsKey(uuid) ? uuid : null;
    }

    @Override
    public int size() {
        return mapUuidStorage.size();
    }

    @Override
    public List<Resume> doGetAllSorted() {
        return new ArrayList<>(mapUuidStorage.values());
    }

    @Override
    public void clear() {
        mapUuidStorage.clear();
    }

}
