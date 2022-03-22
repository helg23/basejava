package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    protected List<Resume> storage = new ArrayList<>();

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
        return storage.toArray(new Resume[0]);
    }

    @Override
    protected Integer findKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected Resume getResume(Integer index) {
        return storage.get(index);
    }

    @Override
    protected void updateResume(Integer index, Resume resume) {
        storage.set(index, resume);
    }

    @Override
    protected void removeResume(Integer index) {
        storage.remove((int) index);
    }

    @Override
    protected void saveResume(Integer index, Resume resume) {
        storage.add(resume);
    }
}
