package edu.dab.modules.doctor_appointment_management.internals.core.services;

import edu.dab.modules.doctor_appointment_management.internals.core.dtos.UpdateAppointmentStatusRequest;
import edu.dab.modules.doctor_appointment_management.internals.core.input_ports.IUpdateAppointmentStatusInputPort;
import edu.dab.modules.doctor_appointment_management.internals.core.models.DoctorAppointmentModel;
import edu.dab.modules.doctor_appointment_management.internals.core.output_ports.IUpdateAppointmentStatusOutputPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateAppointmentStatusService implements IUpdateAppointmentStatusInputPort {

  private final IUpdateAppointmentStatusOutputPort updateAppointmentStatusOutputPort;

  public UpdateAppointmentStatusService(
      IUpdateAppointmentStatusOutputPort updateAppointmentStatusOutputPort) {
    this.updateAppointmentStatusOutputPort = updateAppointmentStatusOutputPort;
  }

  @Override
  public void updateAppointmentStatus(UpdateAppointmentStatusRequest request) {
    DoctorAppointmentModel model = mapToModel(request);
    updateAppointmentStatusOutputPort.updateAppointmentStatus(model);
  }

  private DoctorAppointmentModel mapToModel(UpdateAppointmentStatusRequest request) {
    return DoctorAppointmentModel.create(request.appointmentId(), request.newStatus());
  }
}
