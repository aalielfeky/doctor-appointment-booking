package edu.dab.modules.doctor_appointment_management.internals.core.services;

import static edu.dab.modules.shared.AppointmentStatusEnum.UPCOMING;

import edu.dab.modules.doctor_appointment_management.internals.core.input_ports.IGetUpcomingAppointmentsInputPort;
import edu.dab.modules.doctor_appointment_management.internals.core.models.DoctorAppointmentModel;
import edu.dab.modules.doctor_appointment_management.internals.core.output_ports.IGetAllAppointmentsOutputPort;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetUpcomingAppointmentsService implements IGetUpcomingAppointmentsInputPort {
  private final IGetAllAppointmentsOutputPort getAllAppointmentsPort;

  public GetUpcomingAppointmentsService(IGetAllAppointmentsOutputPort getAllAppointmentsPort) {
    this.getAllAppointmentsPort = getAllAppointmentsPort;
  }

  @Override
  public List<DoctorAppointmentModel> getUpcomingAppointments() {
    return getAllAppointmentsPort.getAllAppointments().stream()
        .filter(appointment -> appointment.getStatus().equals(UPCOMING))
        .toList();
  }
}
