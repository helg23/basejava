package com.urise.webapp.exception;

public class OverflowStorageException extends StorageException{
    public OverflowStorageException(String uuid) {
        super("Массив резюме заполнен. Добавление невозможно.", uuid);
    }
}
