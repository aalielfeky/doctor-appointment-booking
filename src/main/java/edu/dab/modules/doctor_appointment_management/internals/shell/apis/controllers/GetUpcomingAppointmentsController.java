package edu.dab.modules.doctor_appointment_management.internals.shell.apis.controllers;

import edu.dab.modules.doctor_appointment_management.internals.core.input_ports.IGetUpcomingAppointmentsInputPort;
import edu.dab.modules.doctor_appointment_management.internals.shell.apis.dtos.GetUpcomingAppointmentsDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUpcomingAppointmentsController {

  private final IGetUpcomingAppointmentsInputPort getUpcomingAppointmentsPort;

  public GetUpcomingAppointmentsController(
      IGetUpcomingAppointmentsInputPort getUpcomingAppointmentsPort) {
    this.getUpcomingAppointmentsPort = getUpcomingAppointmentsPort;
  }

  @GetMapping("api/doctor-upcoming-appointments")
  public ResponseEntity<List<GetUpcomingAppointmentsDTO>> getUpcomingAppointments() {
    List<GetUpcomingAppointmentsDTO> DTOs =
        getUpcomingAppointmentsPort.getUpcomingAppointments().stream()
            .map(
                model ->
                    new GetUpcomingAppointmentsDTO(
                        model.getAppointmentId(), model.getAppointmentTime(), model.getStatus()))
            .toList();
    return ResponseEntity.ok(DTOs);
  }
}
