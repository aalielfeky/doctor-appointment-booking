package edu.dab.modules.apointment_booking.internals.application.handlers;

import edu.dab.modules.apointment_booking.internals.application.dtos.AppointmentCreateRequest;
import edu.dab.modules.apointment_booking.internals.application.contracts.ICreateAppointment;
import edu.dab.modules.apointment_booking.internals.application.contracts.IUpdateDoctorSlotReservation;
import edu.dab.modules.apointment_booking.internals.domain.models.AppointmentModel;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class BookAppointmentRequestHandler {
  private final ICreateAppointment createAppointment;
  private final IUpdateDoctorSlotReservation updateDoctorSlotReservation;

  public BookAppointmentRequestHandler(
      ICreateAppointment createAppointment,
      IUpdateDoctorSlotReservation updateDoctorSlotReservation) {
    this.createAppointment = createAppointment;
    this.updateDoctorSlotReservation = updateDoctorSlotReservation;
  }

  public UUID handle(AppointmentCreateRequest request) {
    // TODO: validate request
    AppointmentModel appointmentModel = mapFromRequest(request);
    UUID appointmentId = createAppointment.createAppointment(appointmentModel);
    updateDoctorSlotReservation.updateDoctorSlotReservation(appointmentModel.getSlotId());
    return appointmentId;
  }

  private AppointmentModel mapFromRequest(AppointmentCreateRequest request) {
    // TODO: move to mapper
    return AppointmentModel.create(request.slotId(), request.patientId());
  }
}
