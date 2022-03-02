package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.OverflowStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public abstract class AbstractArrayStorageTest {
    private final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void get() throws Exception {
        assertEquals(new Resume(UUID_1), storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void save() throws Exception {
        storage.save(new Resume(UUID_4));
        Resume resume = storage.get(UUID_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(new Resume(UUID_1));
    }

    @Test(expected = OverflowStorageException.class)
    public void saveOverFlow() throws Exception {
        try {
            Field field = storage.getClass().getSuperclass().getDeclaredField("STORAGE_LIMIT");
            field.setAccessible(true);
            int storage_limit = (Integer) field.get(null);
            for (int i = storage.size(); i < storage_limit; i++) {
                storage.save(new Resume("uid" + i));
            }
        } catch (OverflowStorageException e) {
            fail("Переполнение происходит раньше времени");
        }
        storage.save(new Resume("dummy"));
    }

    @Test
    public void update() throws Exception {
        Resume testResume = new Resume(UUID_3);
        storage.update(testResume);
        assertEquals(testResume, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(new Resume("dummy"));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_3);
        storage.get(UUID_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void getAll() throws Exception {
        for (String testUuid : new String[]{UUID_1, UUID_2, UUID_3}) {
            assertEquals(new Resume(testUuid), storage.get(testUuid));
        }
    }
}