package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {


    public Resume get(String uuid) {
        return getResume(searchKey(uuid, true), uuid);
    }

    public void update(Resume resume) {
        updateResume(searchKey(resume.getUuid(), true), resume);
    }

    public void delete(String uuid) {
        removeResume(searchKey(uuid, true), uuid);
    }

    public void save(Resume resume) {
        saveResume(searchKey(resume.getUuid(), false), resume);
    }

    protected abstract int findKey(String uuid);

    protected abstract Resume getResume(int key, String uuid);

    protected abstract void updateResume(int key, Resume resume);

    protected abstract void removeResume(int key, String uuid);

    protected abstract void saveResume(int key, Resume resume);

    private int searchKey(String uuid, boolean mustExist) {
        int key = findKey(uuid);
        if (mustExist && key < 0) {
            throw new NotExistStorageException(uuid);
        }
        if (!mustExist && key >= 0) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }
}
