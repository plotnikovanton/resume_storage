package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertResume(Resume resume) {
            int index = - (Arrays.binarySearch(storage, 0, size, resume)) - 1;
            System.arraycopy(storage, index, storage, index + 1, size - index);
            storage[index] = resume;
    }

    protected int indexOf(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
