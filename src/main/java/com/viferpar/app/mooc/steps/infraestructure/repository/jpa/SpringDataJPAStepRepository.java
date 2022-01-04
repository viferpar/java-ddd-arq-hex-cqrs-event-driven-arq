package com.viferpar.app.mooc.steps.infraestructure.repository.jpa;

import com.viferpar.app.mooc.steps.infraestructure.repository.jpa.entities.JPAStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPAStepRepository extends JpaRepository<JPAStep, String> {

}
