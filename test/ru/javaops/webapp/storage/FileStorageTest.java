package ru.javaops.webapp.storage;

import ru.javaops.webapp.storage.serialization.ObjectStream;

public class FileStorageTest extends AbstractStorageTest {

    public FileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectStream()));
    }
}