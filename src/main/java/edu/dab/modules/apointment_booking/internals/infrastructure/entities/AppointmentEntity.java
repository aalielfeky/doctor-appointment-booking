package edu.dab.modules.apointment_booking.internals.infrastructure.entities;

import edu.dab.modules.shared.AppointmentStatusEnum;
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
  private LocalDateTime appointmentTime;
  private AppointmentStatusEnum status;

  @Builder
  public AppointmentEntity(
      UUID id,
      UUID slotId,
      UUID patientId,
      LocalDateTime reservedAt,
      LocalDateTime appointmentTime,
      AppointmentStatusEnum status) {
    this.id = id;
    this.slotId = slotId;
    this.patientId = patientId;
    this.reservedAt = reservedAt;
    this.appointmentTime = appointmentTime;
    this.status = status;
  }
}
