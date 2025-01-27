package edu.dab.modules.doctor_appointment_management.internals.shell.apis.controllers;

import edu.dab.modules.doctor_appointment_management.internals.core.dtos.UpdateAppointmentStatusRequest;
import edu.dab.modules.doctor_appointment_management.internals.core.input_ports.IUpdateAppointmentStatusInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateAppointmentStatusController {
  private final IUpdateAppointmentStatusInputPort updateAppointmentStatusPort;

  public UpdateAppointmentStatusController(
      IUpdateAppointmentStatusInputPort updateAppointmentStatusPort) {
    this.updateAppointmentStatusPort = updateAppointmentStatusPort;
  }

  @PutMapping("api/doctor-appointment-status")
  public ResponseEntity<Void> updateAppointmentStatus(
      @RequestBody UpdateAppointmentStatusRequest request) {
    // TODO: validate reqeust
    updateAppointmentStatusPort.updateAppointmentStatus(request);
    return ResponseEntity.ok().build();
  }
}
