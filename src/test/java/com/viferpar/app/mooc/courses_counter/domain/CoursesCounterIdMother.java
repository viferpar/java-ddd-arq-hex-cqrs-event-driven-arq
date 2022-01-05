package com.viferpar.app.mooc.courses_counter.domain;

import com.viferpar.app.shared.domain.UuidMother;

public final class CoursesCounterIdMother {

    public static CoursesCounterId create(String value) {
        return new CoursesCounterId(value);
    }

    public static CoursesCounterId random() {
        return create(UuidMother.random());
    }
}
