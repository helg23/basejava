package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;

public abstract class AbstractStorage implements Storage {

    protected int getIndex(String uuid, Boolean mustExist) {
        int index = findIndex(uuid);
        if (mustExist && index < 0) {
            throw new NotExistStorageException(uuid);
        }
        if (!mustExist && index >= 0) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }

    protected abstract int findIndex(String uuid);
}
