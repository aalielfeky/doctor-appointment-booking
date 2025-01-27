package edu.dab.modules.doctor_appointment_management.internals.core.input_ports;

import edu.dab.modules.doctor_appointment_management.internals.core.dtos.UpdateAppointmentStatusRequest;

public interface IUpdateAppointmentStatusInputPort {
  void updateAppointmentStatus(UpdateAppointmentStatusRequest request);
}
