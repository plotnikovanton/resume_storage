package ru.javaops.webapp.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javaops.webapp.exception.ExistStorageException;
import ru.javaops.webapp.exception.NotExistStorageException;
import ru.javaops.webapp.model.Resume;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static ru.javaops.webapp.storage.ResumeTestData.*;

public abstract class AbstractStorageTest {
    protected static final File STORAGE_DIR = new File("C:\\Users\\plotn\\IdeaProjects\\basejava\\storage");

    protected Storage storage;

    AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume testResume1 = testDataResume1;
    private static final Resume testResume2 = testDataResume2;
    private static final Resume testResume3 = testDataResume3;
    private static final Resume testResume4 = testDataResume4;

    @Before
    public void setUp() {
        storage.clear();
        storage.save(testResume1);
        storage.save(testResume2);
        storage.save(testResume3);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void get() {
        assertGet(testResume1);
        assertGet(testResume2);
        assertGet(testResume3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(UUID_4);
    }

    @Test
    public void save() {
        storage.save(testResume4);
        assertGet(testResume4);
        assertSize(4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(testResume2);
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_1, "New Full Name");
        storage.update(newResume);
        assertEquals(newResume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(testResume4);
    }

    @Test
    public void delete() {
        storage.delete(UUID_2);
        assertSize(2);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_4);
    }

    @Test
    public void getAllSorted() {
        List<Resume> resumes = storage.getAllSorted();
        assertEquals(resumes, Arrays.asList(testResume1, testResume2, testResume3));
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}