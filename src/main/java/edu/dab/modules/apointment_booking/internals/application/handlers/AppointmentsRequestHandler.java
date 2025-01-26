package edu.dab.modules.apointment_booking.internals.application.handlers;

import edu.dab.modules.apointment_booking.internals.application.converters.AppointmentConverter;
import edu.dab.modules.apointment_booking.internals.application.dtos.AppointmentDto;
import edu.dab.modules.apointment_booking.internals.domain.models.AppointmentModel;
import edu.dab.modules.apointment_booking.internals.domain.usecases.contracts.IGetAvailableAppointmentsUsecase;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AppointmentsRequestHandler {
  private final IGetAvailableAppointmentsUsecase getAppointmentsUsecase;
  private final AppointmentConverter appointmentConverter;

  public AppointmentsRequestHandler(
      IGetAvailableAppointmentsUsecase getAppointmentsUsecase,
      AppointmentConverter appointmentConverter) {
    this.getAppointmentsUsecase = getAppointmentsUsecase;
    this.appointmentConverter = appointmentConverter;
  }

  public List<AppointmentDto> handleGetAppointments() {
    List<AppointmentModel> appointmentModels = getAppointmentsUsecase.getAppointments();
    return appointmentConverter.convertToDtos(appointmentModels);
  }
}
