/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int i = 0;
        while (i < storage.length && storage[i]!=null) {
            storage[i++]=null;
        }
    }

    void save(Resume resume) {
        for(int i = 0; i < storage.length; i++) {
            if (storage[i]==null){
                storage[i]=resume;
                break;
            }
        }
    }

    Resume get(String uuid) {
        int i = 0;
        while (i< storage.length && storage[i]!=null) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
            i++;
        }
        return null;
    }

    void delete(String uuid) {
        boolean found = false;
        int i = 0;
        while (i< storage.length && storage[i]!=null) {
            if (!found && storage[i].uuid.equals(uuid)){
                storage[i]=null;
                found=true;
            }
            if (found && i < (storage.length-1)){
                storage[i]=storage[i+1];
            }
            i++;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int resumeCount = 0;
        while (resumeCount< storage.length && storage[resumeCount]!=null) {
            resumeCount++;
        }
        Resume[] allResumes = new Resume[resumeCount];
        System.arraycopy(storage,0,allResumes,0,resumeCount);
        return allResumes;
    }

    int size() {
        int size = 0;
        while (size< storage.length && storage[size]!=null) {
            size++;
        }
        return size;
    }
}
