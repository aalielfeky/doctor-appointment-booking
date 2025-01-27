package edu.dab.modules.apointment_booking.internals.apis.controllers;

import edu.dab.modules.apointment_booking.internals.application.dtos.AppointmentCreateRequest;
import edu.dab.modules.apointment_booking.internals.application.handlers.BookAppointmentRequestHandler;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookAppointmentController {
  private final BookAppointmentRequestHandler bookAppointmentRequestHandler;

  public BookAppointmentController(BookAppointmentRequestHandler bookAppointmentRequestHandler) {
    this.bookAppointmentRequestHandler = bookAppointmentRequestHandler;
  }

  @PostMapping("api/appointment")
  public ResponseEntity<UUID> getAvailableSlots(@RequestBody AppointmentCreateRequest request) {
    return ResponseEntity.ok(bookAppointmentRequestHandler.handle(request));
  }
}
