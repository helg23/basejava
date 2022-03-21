package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    protected int findKey(String uuid) {
        return 0;
    }

    @Override
    protected <T> Resume getResume(T key) {
        return storage.get((String) key);
    }

    @Override
    protected <T> void updateResume(T key, Resume resume) {
        storage.put((String) key, resume);
    }

    @Override
    protected <T> void removeResume(T key) {
        storage.remove((String) key);
    }

    @Override
    protected <T> void saveResume(T key, Resume resume) {
        storage.put((String) key, resume);
    }

    @Override
    protected <T> T searchKey(String uuid, boolean mustExist) {
        Resume resume = storage.get(uuid);
        if (mustExist && resume == null) {
            throw new NotExistStorageException(uuid);
        }
        if (!mustExist && resume != null) {
            throw new ExistStorageException(uuid);
        }
        return (T) uuid;
    }
}
