package ru.javaops.webapp.storage;

import ru.javaops.webapp.storage.serialization.ObjectStream;

public class PathStorageTest extends AbstractStorageTest {

    public PathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStream()));
    }
}