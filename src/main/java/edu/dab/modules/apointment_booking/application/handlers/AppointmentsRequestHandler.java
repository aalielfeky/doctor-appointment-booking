package edu.dab.modules.apointment_booking.application.handlers;

import edu.dab.modules.apointment_booking.application.converters.AppointmentConverter;
import edu.dab.modules.apointment_booking.application.dtos.AppointmentDto;
import edu.dab.modules.apointment_booking.domain.models.AppointmentModel;
import edu.dab.modules.apointment_booking.domain.usecases.contracts.IGetAvailableAppointmentsUsecase;
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
