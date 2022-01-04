package com.viferpar.app.mooc.steps.infraestructure.repository;

import com.viferpar.app.mooc.steps.domain.Step;
import com.viferpar.app.mooc.steps.domain.StepId;
import com.viferpar.app.mooc.steps.domain.StepRepository;
import com.viferpar.app.mooc.steps.domain.challenge.ChallengeStep;
import com.viferpar.app.mooc.steps.domain.video.VideoStep;
import com.viferpar.app.mooc.steps.infraestructure.repository.jpa.SpringDataJPAStepRepository;
import com.viferpar.app.mooc.steps.infraestructure.repository.jpa.entities.JPAChallengeStep;
import com.viferpar.app.mooc.steps.infraestructure.repository.jpa.entities.JPAStep;
import com.viferpar.app.mooc.steps.infraestructure.repository.jpa.entities.JPAVideoStep;
import com.viferpar.app.mooc.steps.infraestructure.repository.mapper.ChallengeStepMapper;
import com.viferpar.app.mooc.steps.infraestructure.repository.mapper.VideoStepMapper;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JPAStepRepository implements StepRepository {

  private final SpringDataJPAStepRepository repository;

  private final ChallengeStepMapper challengeStepMapper;

  private final VideoStepMapper videoStepMapper;

  @Override
  @Transactional
  public void save(Step step) {
    repository.save(toJPAEntity(step));
  }

  private JPAStep toJPAEntity(Step step) {
    JPAStep jpaStep = null;

    if (step instanceof ChallengeStep) {
      jpaStep = challengeStepMapper.toJPAEntity((ChallengeStep) step);
    }
    if (step instanceof VideoStep) {
      jpaStep = videoStepMapper.toJPAEntity((VideoStep) step);
    }

    return jpaStep;
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Step> search(StepId id) {
    Optional<JPAStep> jpaCourse = repository.findById(id.getValue());
    return jpaCourse.map(this::toDomainModel);
  }

  private Step toDomainModel(JPAStep jpaStep) {
    Step step = null;

    if (jpaStep instanceof JPAChallengeStep) {
      step = challengeStepMapper.toDomainModel((JPAChallengeStep) jpaStep);
    }
    if (jpaStep instanceof JPAVideoStep) {
      step = videoStepMapper.toDomainModel((JPAVideoStep) jpaStep);
    }

    return step;
  }

}
