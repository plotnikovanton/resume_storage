package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> listStorage = new ArrayList<>();

    @Override
    protected Resume doGet(Object key) {
        int index = (Integer) key;
        return listStorage.get(index);
    }

    @Override
    protected void doSave(Object key, Resume resume) {
        listStorage.add(resume);
    }

    @Override
    protected void doUpdate(Object key, Resume resume) {
        int index = (Integer) key;
        listStorage.set(index, resume);
    }

    @Override
    protected void doDelete(Object key) {
        int index = (Integer) key;
        listStorage.remove(index);
    }

    @Override
    protected boolean isExist(Object key) {
        int index = (Integer) key;
        return index >= 0;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < listStorage.size(); i++) {
            if (uuid.equals(listStorage.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return listStorage.size();
    }

    @Override
    public List<Resume> getAllSorted() {
        Collections.sort(listStorage);
        return listStorage;
    }

    @Override
    public void clear() {
        listStorage.clear();
    }
}
