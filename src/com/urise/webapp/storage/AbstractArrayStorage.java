package com.urise.webapp.storage;

import com.urise.webapp.exception.OverflowStorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
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
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    public void save(Resume resume) {
        if (size == storage.length) {
            throw new OverflowStorageException(resume.getUuid());
        }
        int index = (findIndex(resume.getUuid()));
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        }
        insert(resume, index);
        size++;
    }

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        }
        storage[index] = resume;

    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
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

    protected abstract int findIndex(String uuid);

    protected abstract void insert(Resume resume, int index);
}