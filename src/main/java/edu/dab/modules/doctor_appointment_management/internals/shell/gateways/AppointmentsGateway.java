package edu.dab.modules.doctor_appointment_management.internals.shell.gateways;

import edu.dab.modules.apointment_booking.shared.AppointmentsAPI;
import edu.dab.modules.doctor_appointment_management.internals.core.models.DoctorAppointmentModel;
import edu.dab.modules.doctor_appointment_management.internals.core.ports.IGetAllAppointmentsPort;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AppointmentsGateway implements IGetAllAppointmentsPort {
  private final AppointmentsAPI appointmentsAPI;

  public AppointmentsGateway(AppointmentsAPI appointmentsAPI) {
    this.appointmentsAPI = appointmentsAPI;
  }

  @Override
  public List<DoctorAppointmentModel> getAllAppointments() {
    return appointmentsAPI.getAllAppointments().stream()
        .map(dto -> new DoctorAppointmentModel(dto.appointmentTime(), dto.status()))
        .toList();
  }
}
