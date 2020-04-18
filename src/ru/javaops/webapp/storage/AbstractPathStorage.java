package ru.javaops.webapp.storage;

import ru.javaops.webapp.exception.StorageException;
import ru.javaops.webapp.model.Resume;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AbstractPathStorage extends AbstractStorage<Path> {
    private Path directory;

    protected AbstractPathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(directory + " directory is not writable");
        }
    }

    @Override
    protected Path getSearchKey(String key) {
        return null;
    }

    @Override
    protected boolean isExist(Path key) {
        return false;
    }

    @Override
    protected Resume doGet(Path key) {
        return null;
    }

    @Override
    protected void doSave(Path key, Resume resume) {

    }

    @Override
    protected void doUpdate(Path key, Resume resume) {

    }

    @Override
    protected void doDelete(Path key) {

    }

    @Override
    protected List<Resume> doGetAllSorted() {
        return null;
    }

    @Override
    public Resume get(String uuid) {
        return super.get(uuid);
    }

    @Override
    public void save(Resume resume) {
        super.save(resume);
    }

    @Override
    public void update(Resume resume) {
        super.update(resume);
    }

    @Override
    public void delete(String uuid) {
        super.delete(uuid);
    }

    @Override
    public List<Resume> getAllSorted() {
        return super.getAllSorted();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }
}
