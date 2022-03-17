package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.OverflowStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {


    public Resume get(String uuid) {
        return getResume(getIndex(uuid, true));
    }

    public void update(Resume resume) {
        updateResume(getIndex(resume.getUuid(), true), resume);
    }

    public void delete(String uuid) {
        removeResume(getIndex(uuid, true));
    }

    public void save(Resume resume) {
        saveResume(getIndex(resume.getUuid(), false), resume);
    }

    protected abstract int findIndex(String uuid);

    protected abstract Resume getResume(int index);

    protected abstract void updateResume(int index, Resume resume);

    protected abstract void removeResume(int index);

    protected abstract void saveResume(int index, Resume resume);

    private int getIndex(String uuid, Boolean mustExist) {
        int index = findIndex(uuid);
        if (mustExist && index < 0) {
            throw new NotExistStorageException(uuid);
        }
        if (!mustExist && index >= 0) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }
}
