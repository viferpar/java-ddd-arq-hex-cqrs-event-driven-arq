package com.viferpar.app.mooc.courses.infraestructure.repository.jpa;

import com.viferpar.app.mooc.courses.infraestructure.repository.jpa.entities.JPACourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPACourseRepository extends JpaRepository<JPACourse, String> {

}
