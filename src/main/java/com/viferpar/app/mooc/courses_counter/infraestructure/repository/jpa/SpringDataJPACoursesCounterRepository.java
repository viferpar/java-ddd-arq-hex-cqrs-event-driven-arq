package com.viferpar.app.mooc.courses_counter.infraestructure.repository.jpa;

import com.viferpar.app.mooc.courses_counter.infraestructure.repository.jpa.entities.JPACoursesCounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPACoursesCounterRepository extends
    JpaRepository<JPACoursesCounter, String> {

}
