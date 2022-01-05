package com.viferpar.app.mooc.courses_counter.infraestructure.repository;

import com.viferpar.app.mooc.courses_counter.domain.CoursesCounter;
import com.viferpar.app.mooc.courses_counter.domain.CoursesCounterRepository;
import com.viferpar.app.mooc.courses_counter.infraestructure.repository.jpa.SpringDataJPACoursesCounterRepository;
import com.viferpar.app.mooc.courses_counter.infraestructure.repository.jpa.entities.JPACoursesCounter;
import com.viferpar.app.mooc.courses_counter.infraestructure.repository.mapper.CoursesCounterMapper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JPACoursesCounterRepository implements CoursesCounterRepository {

  private final SpringDataJPACoursesCounterRepository repository;

  private final CoursesCounterMapper mapper;

  @Override
  public void save(CoursesCounter counter) {
    repository.save(mapper.toJPAEntity(counter));
  }

  @Override
  public Optional<CoursesCounter> search() {
    List<JPACoursesCounter> coursesCounter = repository.findAll();

    return coursesCounter.isEmpty() ? Optional.empty()
        : Optional.ofNullable(mapper.toDomainModel(coursesCounter.get(0)));
  }

}
