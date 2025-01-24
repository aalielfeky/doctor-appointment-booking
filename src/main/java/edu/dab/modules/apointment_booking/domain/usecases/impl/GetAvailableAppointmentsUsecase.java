package edu.dab.modules.apointment_booking.domain.usecases.impl;

import edu.dab.modules.apointment_booking.domain.models.AppointmentModel;
import edu.dab.modules.apointment_booking.domain.usecases.contracts.IAppointmentRepo;
import edu.dab.modules.apointment_booking.domain.usecases.contracts.IGetAvailableAppointmentsUsecase;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
class GetAvailableAppointmentsUsecase implements IGetAvailableAppointmentsUsecase {

  private final IAppointmentRepo appointmentRepo;

  public GetAvailableAppointmentsUsecase(IAppointmentRepo appointmentRepo) {
    this.appointmentRepo = appointmentRepo;
  }

  @Override
  public List<AppointmentModel> getAppointments() {
    return appointmentRepo.getAppointments();
  }
}
