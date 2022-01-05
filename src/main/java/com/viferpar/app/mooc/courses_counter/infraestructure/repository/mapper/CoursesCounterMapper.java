package com.viferpar.app.mooc.courses_counter.infraestructure.repository.mapper;

import com.viferpar.app.mooc.courses.domain.CourseId;
import com.viferpar.app.mooc.courses_counter.domain.CoursesCounter;
import com.viferpar.app.mooc.courses_counter.infraestructure.repository.jpa.entities.JPACoursesCounter;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CoursesCounterMapper {

  @Mapping(target = "id", source = "id.value")
  @Mapping(target = "total", source = "total.value")
  @Mapping(target = "existingCourses", source = "existingCourses")
  JPACoursesCounter toJPAEntity(CoursesCounter domainModel);

  @InheritInverseConfiguration
  CoursesCounter toDomainModel(JPACoursesCounter jpaEntity);

  default String fromCourseId(CourseId id) {
    return id == null ? null : id.getValue();
  }

  default CourseId fromStringToCourseId(String id) {
    return new CourseId(id);
  }

}
