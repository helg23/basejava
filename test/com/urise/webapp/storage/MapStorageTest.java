package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Test;

public class MapStorageTest extends AbstractStorageTest {
    public MapStorageTest() {
        super(new MapStorage());
    }

    @Test
    @Override
    public void getAll() {
        for (Resume r : new Resume[]{RESUME_1, RESUME_2, RESUME_3}) {
            assertGet(r);
        }
        assertSize(3);
    }
}