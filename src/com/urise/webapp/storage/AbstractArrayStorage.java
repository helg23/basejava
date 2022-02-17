package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public void save(Resume resume) {
        if (size == storage.length) {
            System.out.println("Массив резюме заполнен. Добавление невозможно.");
        } else {
            int searchResult = (findIndex(resume.getUuid()));
            if (searchResult >= 0) {
                System.out.println("Резюме " + resume.getUuid() + " уже добавлено.");
            } else {
                int insertionPoint = -searchResult - 1;
                insert(resume, insertionPoint);
            }
        }
    }

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("Резюме " + resume.getUuid() + " не найдено");
        } else {
            storage[index] = resume;
        }
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Резюме " + uuid + " не найдено");
        } else {
            size--;
            //если удаляемый элемент последний, то только очищаем его
            if (index == size) {
                storage[index] = null;
                return;
            }
            //если не последний, то смещаем оставшуюся часть массива на 1 ближе к началу
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract int findIndex(String uuid);

    protected abstract void insert(Resume resume, int searchResult);
}