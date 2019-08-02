import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    protected Resume[] storage = new Resume[10000];
    protected int size;

    protected void clear() {
        for (int index = 0; index < size; index++) {
            storage[index] = null;
        }
        size = 0;
    }

    protected void save(Resume r) {
        if (size == storage.length) {
            System.out.println("ArrayStorage is full");
            return;
        } else {
            storage[size] = r;
            size++;
        }
    }

    protected Resume get(String uuid) {
        Resume resume = null;
        for (int index = 0; index < size; index++) {
            if (uuid.equals(storage[index].uuid)) {
                resume = storage[index];
                break;
            }
        }
        return resume;
    }

    protected void delete(String uuid) {
        for (int index = 0; index < size; index++) {
            if (uuid.equals(storage[index].uuid)) {
                storage[index] = null;
                for (int i = index; i < size; i++) {
                    storage[i] = storage[i + 1];
                }
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    protected Resume[] getAll() {
        Resume[] tempStorage = new Resume[size];
        System.arraycopy(storage, 0, tempStorage, 0, size);

        return tempStorage;
    }

    protected int size() {
        return size;
    }
}
