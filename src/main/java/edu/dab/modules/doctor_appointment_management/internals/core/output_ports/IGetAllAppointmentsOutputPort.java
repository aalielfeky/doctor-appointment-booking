package edu.dab.modules.doctor_appointment_management.internals.core.output_ports;

import edu.dab.modules.doctor_appointment_management.internals.core.models.DoctorAppointmentModel;
import java.util.List;

public interface IGetAllAppointmentsOutputPort {
  List<DoctorAppointmentModel> getAllAppointments();
}
