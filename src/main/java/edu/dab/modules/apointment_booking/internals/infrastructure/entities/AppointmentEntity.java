package edu.dab.modules.apointment_booking.internals.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentEntity {
  private UUID id;
  private UUID slotId;
  private UUID patientId;
  private LocalDateTime reservedAt;

  @Builder
  public AppointmentEntity(UUID id, UUID slotId, UUID patientId, LocalDateTime reservedAt) {
    this.id = id;
    this.slotId = slotId;
    this.patientId = patientId;
    this.reservedAt = reservedAt;
  }
}
