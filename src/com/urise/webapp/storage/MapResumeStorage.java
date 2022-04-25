package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {
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
    protected Resume findKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected Resume getResume(Resume key) {
        return key;
    }

    @Override
    protected void updateResume(Resume key, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void removeResume(Resume key) {
        storage.remove(key.getUuid());
    }

    @Override
    protected void saveResume(Resume key, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected boolean checkKeyExist(Resume key) {
        return key != null;
    }
}
