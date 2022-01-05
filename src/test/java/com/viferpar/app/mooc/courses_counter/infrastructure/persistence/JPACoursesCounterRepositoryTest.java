package com.viferpar.app.mooc.courses_counter.infrastructure.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.viferpar.app.mooc.courses_counter.domain.CoursesCounter;
import com.viferpar.app.mooc.courses_counter.domain.CoursesCounterMother;
import com.viferpar.app.mooc.courses_counter.infraestructure.repository.JPACoursesCounterRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
class JPACoursesCounterRepositoryTest {

    @Autowired
    private JPACoursesCounterRepository repository;

    @Test
    void shouldReturnAnExistingCoursesCounter() {
        CoursesCounter counter = CoursesCounterMother.random();

        repository.save(counter);

        assertEquals(Optional.of(counter), repository.search());
    }

}
