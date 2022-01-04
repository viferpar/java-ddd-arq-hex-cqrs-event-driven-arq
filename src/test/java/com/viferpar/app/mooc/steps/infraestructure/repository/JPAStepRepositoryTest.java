package com.viferpar.app.mooc.steps.infraestructure.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.viferpar.app.mooc.steps.domain.Step;
import com.viferpar.app.mooc.steps.infraestructure.domain.StepIdMother;
import com.viferpar.app.mooc.steps.infraestructure.domain.challenge.ChallengeStepMother;
import com.viferpar.app.mooc.steps.infraestructure.domain.video.VideoStepMother;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class JPAStepRepositoryTest {

  @Autowired
  JPAStepRepository repository;

  @Test
  void save_a_step() {
    for (Step step : steps()) {
      repository.save(step);
    }
  }

  @Test
  void return_an_existing_step() {
    for (Step step : steps()) {
      repository.save(step);

      assertEquals(Optional.of(step), repository.search(step.getId()));
    }
  }

  @Test
  void not_return_a_non_existing_course() {
    assertFalse(repository.search(StepIdMother.random()).isPresent());
  }

  private List<? extends Step> steps() {
    return Arrays.asList(ChallengeStepMother.random(), VideoStepMother.random());
  }

}
