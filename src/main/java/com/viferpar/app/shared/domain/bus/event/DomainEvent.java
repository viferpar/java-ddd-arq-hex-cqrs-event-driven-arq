package com.viferpar.app.shared.domain.bus.event;

import com.viferpar.app.shared.domain.Utils;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public abstract class DomainEvent {

  private String aggregateId;
  private String eventId;
  private String occurredOn;

  protected DomainEvent(String aggregateId) {
    this.aggregateId = aggregateId;
    this.eventId = UUID.randomUUID().toString();
    this.occurredOn = Utils.dateToString(LocalDateTime.now());
  }

  protected DomainEvent(String aggregateId, String eventId, String occurredOn) {
    this.aggregateId = aggregateId;
    this.eventId = eventId;
    this.occurredOn = occurredOn;
  }

  protected DomainEvent() {
  }

  public abstract String eventName();

  public abstract Map<String, Serializable> toPrimitives();

  public abstract DomainEvent fromPrimitives(
      String aggregateId,
      Map<String, Serializable> body,
      String eventId,
      String occurredOn
  );

  public String aggregateId() {
    return aggregateId;
  }

  public String eventId() {
    return eventId;
  }

  public String occurredOn() {
    return occurredOn;
  }

}
