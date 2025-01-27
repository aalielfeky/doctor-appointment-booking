package edu.dab.modules.doctor_appointment_management.internals.core.models;

import edu.dab.modules.shared.AppointmentStatusEnum;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;

@Getter
public class DoctorAppointmentModel {
  private UUID appointmentId;
  private LocalDateTime appointmentTime;
  private AppointmentStatusEnum status;

  private DoctorAppointmentModel(
      UUID uuid, LocalDateTime localDateTime, AppointmentStatusEnum status) {
    this.appointmentId = uuid;
    this.appointmentTime = localDateTime;
    this.status = status;
  }

  public static DoctorAppointmentModel create(
      UUID appointmentId, LocalDateTime localDateTime, AppointmentStatusEnum status) {
    return new DoctorAppointmentModel(appointmentId, localDateTime, status);
  }

  public static DoctorAppointmentModel create(UUID appointmentId, AppointmentStatusEnum status) {
    return new DoctorAppointmentModel(appointmentId, null, status);
  }

  public static DoctorAppointmentModel create(String appointmentId, AppointmentStatusEnum status) {
    return new DoctorAppointmentModel(UUID.fromString(appointmentId), null, status);
  }
}
