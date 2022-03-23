package com.urise.webapp.storage;

import com.urise.webapp.exception.OverflowStorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
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
    protected Resume getResume(Integer index) {
        return storage[index];
    }

    @Override
    protected void updateResume(Integer index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected void removeResume(Integer index) {
        System.arraycopy(storage, index + 1, storage, index, size - index);
        size--;
    }

    @Override
    protected void saveResume(Integer index, Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new OverflowStorageException(resume.getUuid());
        }
        insert(index, resume);
        size++;
    }

    @Override
    protected boolean checkKeyExist(Integer key) {
        return key >= 0;
    }
}