package com.viferpar.app.mooc.steps.infraestructure.repository.mapper;

import com.viferpar.app.mooc.steps.domain.video.VideoStep;
import com.viferpar.app.mooc.steps.infraestructure.repository.jpa.entities.JPAVideoStep;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VideoStepMapper {

  @Mapping(target = "id", source = "id.value")
  @Mapping(target = "title", source = "title.value")
  @Mapping(target = "videoUrl", source = "videoUrl.value")
  @Mapping(target = "text", source = "text.value")
  JPAVideoStep toJPAEntity(VideoStep domainModel);

  @InheritInverseConfiguration
  VideoStep toDomainModel(JPAVideoStep jpaEntity);

}
