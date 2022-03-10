package com.urise.webapp.storage;

import com.urise.webapp.exception.OverflowStorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume get(String uuid) {
        return storage[getIndex(uuid, true)];
    }

    public void save(Resume resume) {
        if (size == storage.length) {
            throw new OverflowStorageException(resume.getUuid());
        }
        insert(resume, getIndex(resume.getUuid(), false));
        size++;
    }

    public void update(Resume resume) {
        storage[getIndex(resume.getUuid(), true)] = resume;

    }

    public void delete(String uuid) {
        int index = getIndex(uuid, true);
        size--;
        if (index == size) {
            storage[index] = null;
            return;
        }
        System.arraycopy(storage, index + 1, storage, index, size - index);
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract void insert(Resume resume, int index);
}