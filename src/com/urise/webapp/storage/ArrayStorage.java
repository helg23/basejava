package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    protected int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public void save(Resume resume) {
        if (size == storage.length) {
            System.out.println("Массив резюме заполнен. Добавление невозможно.");
        } else if (findIndex(resume.getUuid()) >= 0) {
            System.out.println("Резюме " + resume.getUuid() + " уже добавлено.");
        } else {
            storage[size++] = resume;
        }
    }

}
