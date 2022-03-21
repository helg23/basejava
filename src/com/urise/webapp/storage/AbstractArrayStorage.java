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

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract void insert(int index, Resume resume);

    @Override
    protected <T> Resume getResume(T index) {
        return storage[(Integer) index];
    }

    @Override
    protected <T> void updateResume(T index, Resume resume) {
        storage[(Integer) index] = resume;
    }

    @Override
    protected <T> void removeResume(T key) {
        int index = (Integer) key;
        System.arraycopy(storage, index + 1, storage, index, size - index);
        size--;
    }

    @Override
    protected <T> void saveResume(T index, Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new OverflowStorageException(resume.getUuid());
        }
        insert((Integer) index, resume);
        size++;
    }
}