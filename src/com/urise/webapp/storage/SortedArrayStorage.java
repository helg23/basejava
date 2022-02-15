package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    public void save(Resume resume) {
        if (size == storage.length) {
            System.out.println("Массив резюме заполнен. Добавление невозможно.");
        } else {
            int index=(findIndex(resume.getUuid()));
            if (index >=0) {
                System.out.println("Резюме " + resume.getUuid() + " уже добавлено.");
            } else {
                index=-index-1;
                System.arraycopy(storage, index, storage, index + 1, size - index);
                storage[index] = resume;
                size++;
            }
        }
    }
}