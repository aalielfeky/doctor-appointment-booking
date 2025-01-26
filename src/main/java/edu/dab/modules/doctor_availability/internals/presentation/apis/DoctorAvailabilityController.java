package edu.dab.modules.doctor_availability.internals.presentation.apis;

import edu.dab.modules.doctor_availability.internals.business.services.DoctorAvailabilityService;
import edu.dab.modules.doctor_availability.internals.presentation.converters.SlotModelConverter;
import edu.dab.modules.doctor_availability.internals.presentation.dtos.SlotCreateRequest;
import edu.dab.modules.doctor_availability.internals.presentation.dtos.SlotDto;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/slots")
public class DoctorAvailabilityController {

  private final DoctorAvailabilityService doctorAvailabilityService;
  private final SlotModelConverter slotModelConverter;

  public DoctorAvailabilityController(
      DoctorAvailabilityService doctorAvailabilityService, SlotModelConverter slotModelConverter) {
    this.doctorAvailabilityService = doctorAvailabilityService;
    this.slotModelConverter = slotModelConverter;
  }

  @GetMapping
  public ResponseEntity<List<SlotDto>> getSlots() {
    List<SlotDto> slots =
        slotModelConverter.convertModelsToDtos(doctorAvailabilityService.getAllSlots());
    return ResponseEntity.ok(slots);
  }

  @PostMapping
  public ResponseEntity<UUID> createSlot(@RequestBody SlotCreateRequest slotCreateRequest) {
    return ResponseEntity.ok(
        doctorAvailabilityService.createSlot(slotModelConverter.convertToModel(slotCreateRequest)));
  }
}
