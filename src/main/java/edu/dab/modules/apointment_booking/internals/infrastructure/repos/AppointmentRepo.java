package edu.dab.modules.apointment_booking.internals.infrastructure.repos;

import edu.dab.modules.apointment_booking.internals.application.contracts.ICreateAppointment;
import edu.dab.modules.apointment_booking.internals.domain.models.AppointmentModel;
import edu.dab.modules.apointment_booking.internals.infrastructure.entities.AppointmentEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentRepo implements ICreateAppointment {

  private final List<AppointmentEntity> APPOINTMENT_ENTITIES = new ArrayList<>();

  @Override
  public UUID createAppointment(AppointmentModel appointmentModel) {
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
        .build();
  }
}
