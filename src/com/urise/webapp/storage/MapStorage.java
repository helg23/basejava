package com.urise.webapp.storage;

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
        return storage.get(uuid) == null ? -1 : 1;
    }

    @Override
    protected Resume getResume(int key, String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void updateResume(int key, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void removeResume(int key, String uuid) {
        storage.remove(uuid);
    }

    @Override
    protected void saveResume(int key, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }
}
