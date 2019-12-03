package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {

    private List<Resume> listStorage = new ArrayList<>();

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
    protected boolean isExist(Integer index) {
        return index >= 0;
    }

    @Override
    protected Resume doGet(Integer index) {
        return listStorage.get(index);
    }

    @Override
    protected void doSave(Integer index, Resume resume) {
        listStorage.add(resume);
    }

    @Override
    protected void doUpdate(Integer index, Resume resume) {
        listStorage.set(index, resume);
    }

    @Override
    protected void doDelete(Integer index) {
        listStorage.remove(index.intValue());
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
