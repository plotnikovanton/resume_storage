package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {

    private Map<String, Resume> mapUiidStorage = new HashMap<>();

    @Override
    protected Resume doGet(Object key) {
        return mapUiidStorage.get((String) key);
    }

    @Override
    protected void doSave(Object key, Resume resume) {
        mapUiidStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doUpdate(Object key, Resume resume) {
        mapUiidStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Object key) {
        mapUiidStorage.remove((String) key);
    }

    @Override
    protected boolean isExist(Object key) {
        return key != null;
    }

    @Override
    protected String getSearchKey(String uuid) {
        return mapUiidStorage.containsKey(uuid) ? uuid : null;
    }

    @Override
    public int size() {
        return mapUiidStorage.size();
    }

    @Override
    public List<Resume> doGetAllSorted() {
        return new ArrayList<>(mapUiidStorage.values());
    }

    @Override
    public void clear() {
        mapUiidStorage.clear();
    }

}
