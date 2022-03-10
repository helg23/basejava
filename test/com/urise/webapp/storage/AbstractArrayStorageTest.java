package com.urise.webapp.storage;

import com.urise.webapp.exception.OverflowStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Test;

import static org.junit.Assert.fail;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = OverflowStorageException.class)
    public void saveOverflow() {
        try {
            for (int i = storage.size(); i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("uid" + i));
            }
        } catch (OverflowStorageException e) {
            fail("Переполнение происходит раньше времени");
        }
        storage.save(new Resume("dummy"));
    }
}