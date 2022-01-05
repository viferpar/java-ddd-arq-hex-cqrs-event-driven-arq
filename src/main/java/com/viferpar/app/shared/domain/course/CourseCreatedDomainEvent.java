package com.viferpar.app.shared.domain.course;

import com.viferpar.app.shared.domain.bus.event.DomainEvent;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class CourseCreatedDomainEvent extends DomainEvent {

  private String name;
  private String duration;

  public CourseCreatedDomainEvent() {
    super(null);
    this.name = null;
    this.duration = null;
  }

  public CourseCreatedDomainEvent(String aggregateId, String name, String duration) {
    super(aggregateId);
    this.name = name;
    this.duration = duration;
  }

  public CourseCreatedDomainEvent(String aggregateId, String eventId, String occurredOn,
      String name, String duration
  ) {
    super(aggregateId, eventId, occurredOn);
    this.name = name;
    this.duration = duration;
  }

  @Override
  public String eventName() {
    return "course.created";
  }

  @Override
  public Map<String, Serializable> toPrimitives() {
    Map<String, Serializable> map = new HashMap<>();
    map.put("name", name);
    map.put("duration", duration);
    return map;
  }

  @Override
  public DomainEvent fromPrimitives(String aggregateId, Map<String, Serializable> body,
      String eventId, String occurredOn) {
    return new CourseCreatedDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("name"),
        (String) body.get("duration"));
  }

}
