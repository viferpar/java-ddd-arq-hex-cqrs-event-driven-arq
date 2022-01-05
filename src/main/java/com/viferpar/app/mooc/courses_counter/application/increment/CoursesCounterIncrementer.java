package com.viferpar.app.mooc.courses_counter.application.increment;

import com.viferpar.app.mooc.courses.domain.CourseId;
import com.viferpar.app.mooc.courses_counter.domain.CoursesCounter;
import com.viferpar.app.mooc.courses_counter.domain.CoursesCounterRepository;
import com.viferpar.app.shared.domain.UuidGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CoursesCounterIncrementer {

  private final CoursesCounterRepository repository;
  private final UuidGenerator uuidGenerator;

  public void increment(CourseId id) {
    CoursesCounter counter = repository.search()
        .orElseGet(() -> CoursesCounter.initialize(uuidGenerator.generate()));

    if (!counter.hasIncremented(id)) {
      counter.increment(id);

      repository.save(counter);
    }
  }

}
