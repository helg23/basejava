package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {

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

    public List<Resume> getAllSorted() {
        List<Resume> storageList=asList();
        storageList.sort(Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid));
        return storageList;
    }

    protected abstract SK findKey(String uuid);

    protected abstract Resume getResume(SK key);

    protected abstract void updateResume(SK key, Resume resume);

    protected abstract void removeResume(SK key);

    protected abstract void saveResume(SK key, Resume resume);

    protected SK searchKey(String uuid, boolean mustExist) {
        SK key = findKey(uuid);
        boolean keyExists = checkKeyExist(key);
        if (mustExist && !keyExists) {
            throw new NotExistStorageException(uuid);
        }
        if (!mustExist && keyExists) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    protected abstract boolean checkKeyExist(SK key);

    protected abstract List<Resume> asList();
}
