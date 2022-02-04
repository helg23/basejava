/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int size = 0; //счетчик непустых элементов

    void clear() {
        for (int i = 0; i < this.size; i++) {
            storage[i] = null;
        }
        this.size=0;
    }

    void save(Resume resume) {
        if (this.size == storage.length) {
            return;  //не добавляем если массив заполнен
        }
        if (this.get(resume.uuid)!= null){
            return; //не добавляем если элемент уже есть
        }
        storage[this.size++] = resume;
    }

    Resume get(String uuid) {
        for (int i = 0; i < this.size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        boolean found = false;
        for (int i = 0; i < this.size; i++) {
            if (!found && storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                found = true;
            }
            if (found && i < (storage.length - 1)) {
                storage[i] = storage[i + 1];
            }
        }
        this.size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResumes = new Resume[this.size];
        System.arraycopy(storage, 0, allResumes, 0, this.size);
        return allResumes;
    }

    int size() {
        return this.size;
    }
}
