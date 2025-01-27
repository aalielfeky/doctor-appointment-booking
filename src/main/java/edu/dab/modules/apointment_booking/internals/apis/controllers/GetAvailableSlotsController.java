package edu.dab.modules.apointment_booking.internals.apis.controllers;

import edu.dab.modules.apointment_booking.internals.application.dtos.AvailableSlotsDTO;
import edu.dab.modules.apointment_booking.internals.application.handlers.GetAvailableSlotsRequestHandler;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class GetAvailableSlotsController {
  private final GetAvailableSlotsRequestHandler getAvailableSlotsRequestHandler;

  public GetAvailableSlotsController(
      GetAvailableSlotsRequestHandler getAvailableSlotsRequestHandler) {
    this.getAvailableSlotsRequestHandler = getAvailableSlotsRequestHandler;
  }

  @GetMapping("/available-slots")
  public ResponseEntity<List<AvailableSlotsDTO>> getAvailableSlots() {
    return ResponseEntity.ok(getAvailableSlotsRequestHandler.handleGetAvailableSlots());
  }
}
