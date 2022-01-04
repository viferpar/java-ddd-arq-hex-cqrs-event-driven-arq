package com.viferpar.app.mooc.courses.infraestructure.repository;

import com.viferpar.app.mooc.courses.domain.Course;
import com.viferpar.app.mooc.courses.domain.CourseId;
import com.viferpar.app.mooc.courses.domain.CourseRepository;
import com.viferpar.app.mooc.courses.infraestructure.repository.jpa.SpringDataJPACourseRepository;
import com.viferpar.app.mooc.courses.infraestructure.repository.jpa.entities.JPACourse;
import com.viferpar.app.mooc.courses.infraestructure.repository.mapper.CourseMapper;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JPACourseRepository implements CourseRepository {

  private final SpringDataJPACourseRepository repository;

  private final CourseMapper mapper;

  @Override
  @Transactional
  public void save(Course course) {
    repository.save(mapper.toJPAEntity(course));
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Course> search(CourseId id) {
    Optional<JPACourse> jpaCourse = repository.findById(id.getValue());
    return jpaCourse.map(mapper::toDomainModel);
  }

}
