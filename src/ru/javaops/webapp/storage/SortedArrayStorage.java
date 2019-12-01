package ru.javaops.webapp.storage;

import ru.javaops.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private final Comparator<Resume> COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected void insertResume(Resume resume, int index) {
        int insertionPosition = -index - 1;
        System.arraycopy(storage, insertionPosition, storage, insertionPosition + 1, size - insertionPosition);
        storage[insertionPosition] = resume;
    }

    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "Some Name");
        return Arrays.binarySearch(storage, 0, size, searchKey, COMPARATOR);
    }

    @Override
    protected void removeResume(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }
}
