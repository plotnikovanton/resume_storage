package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> listStorage = new ArrayList<>();

    @Override
    protected Resume doGet(Object index) {
        return listStorage.get((int) index);
    }

    @Override
    protected void doSave(Object index, Resume resume) {
        listStorage.add(resume);
    }

    @Override
    protected void doUpdate(Object index, Resume resume) {
        listStorage.set((int) index, resume);
    }

    @Override
    protected void doDelete(Object index) {
        listStorage.remove((int) index);
    }

    @Override
    protected boolean isExist(Object index) {
        return (int) index >= 0;
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
    public List<Resume> doGetAllSorted() {
        return listStorage;
    }

    @Override
    public void clear() {
        listStorage.clear();
    }
}
