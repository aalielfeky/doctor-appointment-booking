package edu.dab.modules.doctor_appointment_management.internals.shell.apis.controllers;

import edu.dab.modules.doctor_appointment_management.internals.core.ports.IGetUpcomingAppointmentsPort;
import edu.dab.modules.doctor_appointment_management.internals.shell.apis.dtos.GetUpcomingAppointmentsDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpcomingAppointmentsController {

  private final IGetUpcomingAppointmentsPort getUpcomingAppointmentsPort;

  public UpcomingAppointmentsController(IGetUpcomingAppointmentsPort getUpcomingAppointmentsPort) {
    this.getUpcomingAppointmentsPort = getUpcomingAppointmentsPort;
  }

  @GetMapping("api/doctor-upcoming-appointments")
  public ResponseEntity<List<GetUpcomingAppointmentsDTO>> getUpcomingAppointments() {
    List<GetUpcomingAppointmentsDTO> DTOs =
        getUpcomingAppointmentsPort.getUpcomingAppointments().stream()
            .map(model -> new GetUpcomingAppointmentsDTO(model.appointmentTime(), model.status()))
            .toList();
    return ResponseEntity.ok(DTOs);
  }
}
