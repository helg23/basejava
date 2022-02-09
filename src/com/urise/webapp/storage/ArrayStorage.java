package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];

    private int size; //счетчик непустых элементов

    private final int NOT_FOUND = -1; //номер ненайденного элемента

    public void clear() {
        Arrays.fill(storage, 0, size - 1, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size == storage.length) {
            System.out.println("Массив резюме заполнен. Добавление невозможно.");
        } else if (find(resume.getUuid()) != NOT_FOUND) {
            System.out.println("Резюме " + resume.getUuid() + " уже добавлено.");
        } else {
            storage[size++] = resume;
        }
    }

    public Resume get(String uuid) {
        int index = find(uuid);
        if (index == NOT_FOUND) {
            System.out.println("Резюме " + uuid + " не найдено");
            return null;
        } else {
            return storage[index];
        }
    }

    public void delete(String uuid) {
        int index = find(uuid);
        if (index == NOT_FOUND) {
            System.out.println("Резюме " + uuid + " не найдено");
        } else {
            storage[index] = null;
            for (int i = index; i < size; i++) {
                if (i < (storage.length - 1)) {
                    storage[i] = storage[i + 1];
                }
            }
            size--;
        }
    }

    public void update(Resume resume) {
        int index = find(resume.getUuid());
        if (index == NOT_FOUND) {
            System.out.println("Резюме " + resume.getUuid() + " не найдено");
        } else {
            storage[index] = resume;
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

    private Integer find(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
