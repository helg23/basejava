package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {


    public Resume get(String uuid) {
        return getResume(searchKey(uuid, true));
    }

    public void update(Resume resume) {
        updateResume(searchKey(resume.getUuid(), true), resume);
    }

    public void delete(String uuid) {
        removeResume(searchKey(uuid, true));
    }

    public void save(Resume resume) {
        saveResume(searchKey(resume.getUuid(), false), resume);
    }

    protected abstract int findKey(String uuid);

    protected abstract <T> Resume getResume(T key);

    protected abstract <T> void updateResume(T key, Resume resume);

    protected abstract <T> void removeResume(T key);

    protected abstract <T> void saveResume(T key, Resume resume);

    protected <T> T searchKey(String uuid, boolean mustExist) {
        int key = findKey(uuid);
        if (mustExist && key < 0) {
            throw new NotExistStorageException(uuid);
        }
        if (!mustExist && key >= 0) {
            throw new ExistStorageException(uuid);
        }
        return (T) (Integer) key;
    }
}
