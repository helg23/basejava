package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {
    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> asList() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected String findKey(String uuid) {
        return storage.containsKey(uuid) ? uuid : null;
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

    @Override
    protected boolean checkKeyExist(String key) {
        return key != null;
    }
}
