package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Test;

public class MapUuidStorageTest extends AbstractStorageTest {
    public MapUuidStorageTest() {
        super(new MapUuidStorage());
    }

    @Test
    @Override
    public void getAllSorted() {
        for (Resume r : new Resume[]{RESUME_1, RESUME_2, RESUME_3}) {
            assertGet(r);
        }
        assertSize(3);
    }
}