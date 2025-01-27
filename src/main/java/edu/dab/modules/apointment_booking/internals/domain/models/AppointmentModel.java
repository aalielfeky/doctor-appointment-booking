package edu.dab.modules.apointment_booking.internals.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

import edu.dab.modules.shared.AppointmentStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentModel {
  private UUID slotId;
  private UUID patientId;
  private LocalDateTime reservedAt;
  private AppointmentStatusEnum status;

  private String doctorName;
  private String patientName;
  private LocalDateTime appointmentTime;

  private AppointmentModel(UUID slotId, UUID patientId) {
    this.slotId = slotId;
    this.patientId = patientId;
    this.reservedAt = LocalDateTime.now();
    this.status = AppointmentStatusEnum.UPCOMING;
  }

  public static AppointmentModel create(String slotId, String patientId) {
    return new AppointmentModel(UUID.fromString(slotId), UUID.fromString(patientId));
  }
}
