package edu.dab.modules.apointment_booking.internals.infrastructure.repos;

import edu.dab.modules.apointment_booking.internals.application.contracts.ICreateAppointment;
import edu.dab.modules.apointment_booking.internals.application.dtos.AvailableSlotsDTO;
import edu.dab.modules.apointment_booking.internals.domain.models.AppointmentModel;
import edu.dab.modules.apointment_booking.internals.infrastructure.entities.AppointmentEntity;
import edu.dab.modules.apointment_booking.internals.infrastructure.gateways.DoctorAvailabilityGateway;
import edu.dab.modules.shared.AppointmentStatusEnum;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentRepo implements ICreateAppointment {

  private final List<AppointmentEntity> APPOINTMENT_ENTITIES = new ArrayList<>();

  private final DoctorAvailabilityGateway doctorAvailabilityGateway;
  private final PatientRepo patientRepo;

  public AppointmentRepo(
      DoctorAvailabilityGateway doctorAvailabilityGateway, PatientRepo patientRepo) {
    this.doctorAvailabilityGateway = doctorAvailabilityGateway;
    this.patientRepo = patientRepo;
  }

  @Override
  public UUID createAppointment(AppointmentModel appointmentModel) {
    setAppointmentAdditionalInfo(appointmentModel);
    AppointmentEntity entity = mapFromModel(appointmentModel);
    APPOINTMENT_ENTITIES.add(entity);
    return entity.getId();
  }

  // TODO: move to mapper
  private AppointmentEntity mapFromModel(AppointmentModel appointmentModel) {
    return AppointmentEntity.builder()
        .id(UUID.randomUUID())
        .slotId(appointmentModel.getSlotId())
        .patientId(appointmentModel.getPatientId())
        .reservedAt(appointmentModel.getReservedAt())
        .appointmentTime(appointmentModel.getAppointmentTime())
        .status(appointmentModel.getStatus())
        .build();
  }

  private void setAppointmentAdditionalInfo(AppointmentModel appointmentModel) {
    AvailableSlotsDTO slotsDTO =
        doctorAvailabilityGateway.getSlotById(appointmentModel.getSlotId());
    String doctorName = slotsDTO.doctorName();
    LocalDateTime appointmentTime = slotsDTO.startDate();
    String patientName =
        patientRepo.findPatientById(appointmentModel.getPatientId()).getPatientName();

    appointmentModel.setDoctorName(doctorName);
    appointmentModel.setAppointmentTime(appointmentTime);
    appointmentModel.setPatientName(patientName);
  }

  public List<AppointmentEntity> getAllAppointments() {
    return APPOINTMENT_ENTITIES;
  }

  public void updateAppointmentStatusById(UUID appointmentId, AppointmentStatusEnum newStatus) {
    APPOINTMENT_ENTITIES.stream()
        .filter(entity -> entity.getId().equals(appointmentId))
        .findFirst()
        .ifPresent(
            entity -> {
              entity.setStatus(newStatus);
            });
  }
}
