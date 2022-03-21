package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
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
    protected int findKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected <T> Resume getResume(T index) {
        return storage.get((int) index);
    }

    @Override
    protected <T> void updateResume(T index, Resume resume) {
        storage.set((Integer) index, resume);
    }

    @Override
    protected <T> void removeResume(T index) {
        storage.remove((int) index);
    }

    @Override
    protected <T> void saveResume(T index, Resume resume) {
        storage.add(resume);
    }
}
