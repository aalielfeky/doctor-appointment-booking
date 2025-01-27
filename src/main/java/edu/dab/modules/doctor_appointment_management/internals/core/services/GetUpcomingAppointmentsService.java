package edu.dab.modules.doctor_appointment_management.internals.core.services;

import static edu.dab.modules.shared.AppointmentStatusEnum.UPCOMING;

import edu.dab.modules.doctor_appointment_management.internals.core.models.DoctorAppointmentModel;
import edu.dab.modules.doctor_appointment_management.internals.core.ports.IGetAllAppointmentsPort;
import edu.dab.modules.doctor_appointment_management.internals.core.ports.IGetUpcomingAppointmentsPort;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetUpcomingAppointmentsService implements IGetUpcomingAppointmentsPort {
  private final IGetAllAppointmentsPort getAllAppointmentsPort;

  public GetUpcomingAppointmentsService(IGetAllAppointmentsPort getAllAppointmentsPort) {
    this.getAllAppointmentsPort = getAllAppointmentsPort;
  }

  @Override
  public List<DoctorAppointmentModel> getUpcomingAppointments() {
    return getAllAppointmentsPort.getAllAppointments().stream()
        .filter(appointment -> appointment.status().equals(UPCOMING))
        .toList();
  }
}
