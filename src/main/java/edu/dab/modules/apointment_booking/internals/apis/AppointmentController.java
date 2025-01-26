package edu.dab.modules.apointment_booking.internals.apis;

import edu.dab.modules.apointment_booking.internals.application.dtos.AppointmentDto;
import edu.dab.modules.apointment_booking.internals.application.handlers.AppointmentsRequestHandler;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/appointments")
public class AppointmentController {
  private final AppointmentsRequestHandler appointmentsRequestHandler;

  public AppointmentController(AppointmentsRequestHandler appointmentsRequestHandler) {
    this.appointmentsRequestHandler = appointmentsRequestHandler;
  }

  @GetMapping
  public ResponseEntity<List<AppointmentDto>> getAppointments() {
    return ResponseEntity.ok(appointmentsRequestHandler.handleGetAppointments());
  }
}
