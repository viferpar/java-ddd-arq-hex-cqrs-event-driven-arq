package com.viferpar.app.shared.domain.bus.event;

import com.viferpar.app.shared.domain.Utils;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class DomainEvent {

  private String aggregateId;
  private String eventId;
  private String occurredOn;

  protected DomainEvent(String aggregateId) {
    this.aggregateId = aggregateId;
    this.eventId = UUID.randomUUID().toString();
    this.occurredOn = Utils.dateToString(LocalDateTime.now());
  }

  public abstract String eventName();

  public abstract Map<String, Serializable> toPrimitives();

  public abstract DomainEvent fromPrimitives(
      String aggregateId,
      Map<String, Serializable> body,
      String eventId,
      String occurredOn
  );

}
