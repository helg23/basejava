/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int size; //счетчик непустых элементов

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume resume) {
        if (size == storage.length) {
            return;  //не добавляем если массив заполнен
        }
        if (get(resume.uuid) != null) {
            return; //не добавляем если элемент уже есть
        }
        storage[size++] = resume;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (!found && storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                found = true;
            }
            if (found && i < (storage.length - 1) && storage[i + 1] != null) {
                storage[i] = storage[i + 1];
            }
        }
        if (found) {
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResumes = new Resume[size];
        System.arraycopy(storage, 0, allResumes, 0, size);
        return allResumes;
    }

    int size() {
        return size;
    }
}
