package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Map;
import java.util.TreeMap;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> mapStorage = new TreeMap<>();

    @Override
    protected Resume getResume(Object key) {
        String searchKey = (String) key;
        return mapStorage.get(searchKey);
    }

    @Override
    protected void saveResume(Object key, Resume resume) {
        mapStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateResume(Object key, Resume resume) {
        mapStorage.replace(resume.getUuid(), resume);
    }

    @Override
    protected void deleteResume(Object key) {
        String searchKey = (String) key;
        mapStorage.remove(searchKey);
    }

    @Override
    protected boolean isExist(Object key) {
        return key != null;
    }

    @Override
    protected Object findKey(String uuid) {
        return mapStorage.containsKey(uuid) ? uuid : null;
    }

    @Override
    public int size() {
        return mapStorage.size();
    }

    @Override
    public Resume[] getAll() {
        return mapStorage.values().toArray(new Resume[mapStorage.size()]);
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

}
