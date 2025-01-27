package edu.dab.modules.doctor_appointment_management.internals.core.input_ports;

import edu.dab.modules.doctor_appointment_management.internals.core.models.DoctorAppointmentModel;
import java.util.List;

public interface IGetUpcomingAppointmentsInputPort {
  List<DoctorAppointmentModel> getUpcomingAppointments();
}
