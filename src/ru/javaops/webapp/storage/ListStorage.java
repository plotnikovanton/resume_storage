package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> listStorage = new ArrayList<>();

    @Override
    protected Resume getResume(Object key) {
        int index = (Integer) key;
        return listStorage.get(index);
    }

    @Override
    protected void saveResume(Object key, Resume resume) {
        listStorage.add(resume);
    }

    @Override
    protected void updateResume(Object key, Resume resume) {
        int index = (Integer) key;
        listStorage.set(index, resume);
    }

    @Override
    protected void deleteResume(Object key) {
        int index = (Integer) key;
        listStorage.remove(index);
    }

    @Override
    protected boolean isExist(Object key) {
        int index = (Integer) key;
        return index >= 0;
    }

    @Override
    protected Integer findKey(String uuid) {
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
    public Resume[] getAll() {
        return listStorage.toArray(new Resume[listStorage.size()]);
    }

    @Override
    public void clear() {
        listStorage.clear();
    }
}
