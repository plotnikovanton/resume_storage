package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    List<Resume> listStorage = new ArrayList<>();

    @Override
    protected Resume getResume(String uuid) {
        int index = findKey(uuid);
        return listStorage.get(index);
    }

    @Override
    protected void saveResume(Resume resume) {
        listStorage.add(resume);
    }

    @Override
    protected void updateResume(Resume resume) {
        int index = findKey(resume.getUuid());
        listStorage.set(index, resume);
    }

    @Override
    protected void deleteResume(String uuid) {
        int index = findKey(uuid);
        listStorage.remove(index);
    }

    @Override
    protected boolean isExist(Object key) {
        return listStorage.contains(key);
    }

    @Override
    protected Integer findKey(String uuid) {
        return listStorage.indexOf(uuid);
    }

    @Override
    public int size() {
        return listStorage.size();
    }

    @Override
    public Resume[] getAll() {
        int size = listStorage.size();
        Resume[] arr = new Resume[size];
        for (int i = 0; i < size; i++) {
            arr[i] = listStorage.get(i);
        }
        return arr;
    }

    @Override
    public void clear() {
        listStorage.clear();
    }
}
