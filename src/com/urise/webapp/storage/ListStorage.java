package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void update(Resume resume) {
        storage.set(getIndex(resume.getUuid(), true), resume);
    }

    @Override
    public void save(Resume resume) {
        getIndex(resume.getUuid(), false);
        storage.add(resume);
    }

    @Override
    public Resume get(String uuid) {
        return storage.get(getIndex(uuid, true));
    }

    @Override
    public void delete(String uuid) {
        storage.remove(getIndex(uuid, true));
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    protected int findIndex(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
