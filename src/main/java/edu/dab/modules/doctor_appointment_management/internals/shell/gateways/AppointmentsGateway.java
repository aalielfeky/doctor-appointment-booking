package edu.dab.modules.doctor_appointment_management.internals.shell.gateways;

import edu.dab.modules.apointment_booking.shared.AppointmentsAPI;
import edu.dab.modules.doctor_appointment_management.internals.core.models.DoctorAppointmentModel;
import edu.dab.modules.doctor_appointment_management.internals.core.output_ports.IGetAllAppointmentsOutputPort;
import java.util.List;

import edu.dab.modules.doctor_appointment_management.internals.core.output_ports.IUpdateAppointmentStatusOutputPort;
import org.springframework.stereotype.Service;

@Service
public class AppointmentsGateway
    implements IGetAllAppointmentsOutputPort, IUpdateAppointmentStatusOutputPort {
  private final AppointmentsAPI appointmentsAPI;

  public AppointmentsGateway(AppointmentsAPI appointmentsAPI) {
    this.appointmentsAPI = appointmentsAPI;
  }

  @Override
  public List<DoctorAppointmentModel> getAllAppointments() {
    return appointmentsAPI.getAllAppointments().stream()
        .map(
            dto ->
                DoctorAppointmentModel.create(
                    dto.appointmentId(), dto.appointmentTime(), dto.status()))
        .toList();
  }

  @Override
  public void updateAppointmentStatus(DoctorAppointmentModel model) {
    appointmentsAPI.updateAppointmentStatusById(model.getAppointmentId(),model.getStatus());
  }
}
