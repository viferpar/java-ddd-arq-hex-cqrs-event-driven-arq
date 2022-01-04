package com.viferpar.app.mooc.courses.infraestructure.repository.mapper;

import com.viferpar.app.mooc.courses.domain.Course;
import com.viferpar.app.mooc.courses.infraestructure.repository.jpa.entities.JPACourse;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

  @Mapping(target="id", source="id.value")
  @Mapping(target="name", source="name.value")
  @Mapping(target="duration", source="duration.value")
  JPACourse toJPAEntity(Course domainModel);

  @InheritInverseConfiguration
  Course toDomainModel(JPACourse jpaEntity);

}
