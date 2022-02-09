package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int size; //счетчик непустых элементов

    public void clear() {
        Arrays.fill(storage, 0, size - 1, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size == storage.length) {
            System.out.println("Массив резюме заполнен. Добавление невозможно.");
        } else if (getByUuid(resume.uuid) != null) {
            System.out.println("Резюме уже добавлено.");
        } else {
            storage[size++] = resume;
        }
    }

    public Resume get(String uuid) {
        Resume resume = getByUuid(uuid);
        if (resume != null) {
            return resume;
        } else {
            System.out.println("Резюме не найдено");
            return null;
        }
    }

    private Resume getByUuid(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (!found && storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                found = true;
            }
            if (found && i < (storage.length - 1)) {
                storage[i] = storage[i + 1];
            }
        }
        if (found) {
            size--;
        } else {
            System.out.println("Резюме не найдено");
        }
    }

    public void update(Resume resume) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(resume.uuid)) {
                storage[i] = resume;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Резюме не найдено");
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
