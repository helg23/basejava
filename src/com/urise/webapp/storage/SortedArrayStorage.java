package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer findKey(String uuid) {
        Resume searchKey = new Resume(uuid,"");
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void insert(int index, Resume resume) {
        int insertPoint = -index - 1;
        System.arraycopy(storage, insertPoint, storage, insertPoint + 1, size - insertPoint);
        storage[insertPoint] = resume;
    }
}