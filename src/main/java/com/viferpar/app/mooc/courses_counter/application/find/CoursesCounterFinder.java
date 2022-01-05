package com.viferpar.app.mooc.courses_counter.application.find;

import com.viferpar.app.mooc.courses_counter.domain.CoursesCounter;
import com.viferpar.app.mooc.courses_counter.domain.CoursesCounterNotInitialized;
import com.viferpar.app.mooc.courses_counter.domain.CoursesCounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class CoursesCounterFinder {

  private final CoursesCounterRepository repository;

  public CoursesCounterResponse find() {
    CoursesCounter coursesCounter = repository.search().orElseThrow(
        CoursesCounterNotInitialized::new);

    return new CoursesCounterResponse(coursesCounter.getTotal().getValue());
  }

}
