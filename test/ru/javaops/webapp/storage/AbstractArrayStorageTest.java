package ru.javaops.webapp.storage;

import org.junit.Test;
import ru.javaops.webapp.exception.StorageException;
import ru.javaops.webapp.model.Resume;

import static org.junit.Assert.fail;

public class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = storage.size(); i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("Full Name" + " " + i));
            }
        } catch (StorageException e) {
            fail("Too early");
        }
        storage.save(new Resume("Very Full Name"));
    }
}
