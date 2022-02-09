package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];

    //счетчик количества резюме
    private int size;

    //номер ненайденного элемента
    private final int NOT_FOUND = -1;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size == storage.length) {
            System.out.println("Массив резюме заполнен. Добавление невозможно.");
        } else if (findIndex(resume.getUuid()) != NOT_FOUND) {
            System.out.println("Резюме " + resume.getUuid() + " уже добавлено.");
        } else {
            storage[size++] = resume;
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index == NOT_FOUND) {
            System.out.println("Резюме " + uuid + " не найдено");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index == NOT_FOUND) {
            System.out.println("Резюме " + uuid + " не найдено");
        } else {
            storage[index] = null;
            size--;
            //если удаляемый элемент последний, то никаких действий больше не требуется
            if (index == size) {
                return;
            }
            //если не последний, то смещаем оставшуюся часть массива на 1 ближе к началу
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
    }

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
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

    private Integer findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
