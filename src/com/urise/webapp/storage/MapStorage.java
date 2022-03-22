package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage<String> {
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
    protected String findKey(String uuid) {
        return storage.get(uuid) == null ? "" : uuid;
    }

    @Override
    protected Resume getResume(String key) {
        return storage.get(key);
    }

    @Override
    protected void updateResume(String key, Resume resume) {
        storage.put(key, resume);
    }

    @Override
    protected void removeResume(String key) {
        storage.remove(key);
    }

    @Override
    protected void saveResume(String key, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }
}
