package edu.dab.modules.doctor_appointment_management.internals.core.output_ports;

import edu.dab.modules.doctor_appointment_management.internals.core.models.DoctorAppointmentModel;

public interface IUpdateAppointmentStatusOutputPort {
  void updateAppointmentStatus(DoctorAppointmentModel model);
}
