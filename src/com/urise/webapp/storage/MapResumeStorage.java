package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {
    private final Map<Resume, Resume> storage = new HashMap<>();

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
        Resume resume = new Resume(uuid,uuid);
        return storage.containsKey(resume) ? resume : null;
    }

    @Override
    protected Resume getResume(Resume key) {
        return storage.get(key);
    }

    @Override
    protected void updateResume(Resume key, Resume resume) {
        storage.put(key, resume);
    }

    @Override
    protected void removeResume(Resume key) {
        storage.remove(key);
    }

    @Override
    protected void saveResume(Resume key, Resume resume) {
        storage.put(resume, resume);
    }

    @Override
    protected boolean checkKeyExist(Resume key) {
        return key != null;
    }
}
