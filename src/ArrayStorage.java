/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume resume) {
        if (size == storage.length) {
            System.out.println("ArrayStorage is full");
        } else if (!isContained(resume)) {
            storage[size] = resume;
            size++;
        } else {
            System.out.println("Resume already exists");
        }
    }

    Resume get(String uuid) {
        if (isContained(uuid)) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].uuid)) {
                    return storage[i];
                }
            }
        }
        System.out.println("No such resume");
        return null;
    }

    void delete(String uuid) {
        if (isContained(uuid)) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].uuid)) {
                    System.arraycopy(storage, i + 1, storage, i, size - i - 1);
                    storage[size - i] = null;
                    size--;
                }
            }
        } else {
            System.out.println("No such resume");
        }
    }

    void update(Resume resume) {
        if (isContained(resume)) {
            for (int i = 0; i < size; i++) {
                if (resume.equals(storage[i])) {
                    storage[i] = resume;
                    break;
                }
            }
        } else {
            System.out.println("No such resume");
        }
    }

    private boolean isContained(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (resume.equals(storage[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean isContained(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        System.arraycopy(storage, 0, resumes, 0, size);

        return resumes;
    }

    int size() {
        return size;
    }
}
