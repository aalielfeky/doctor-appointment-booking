package edu.dab.modules.doctor_appointment_management.internals.core.ports;

import edu.dab.modules.doctor_appointment_management.internals.core.models.DoctorAppointmentModel;
import java.util.List;

public interface IGetUpcomingAppointmentsPort {
  List<DoctorAppointmentModel> getUpcomingAppointments();
}
