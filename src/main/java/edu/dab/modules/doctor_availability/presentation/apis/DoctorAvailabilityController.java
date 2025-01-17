package edu.dab.modules.doctor_availability.presentation.apis;

import edu.dab.modules.doctor_availability.business.services.DoctorAvailabilityService;
import edu.dab.modules.doctor_availability.presentation.converters.SlotModelDtoConverter;
import edu.dab.modules.doctor_availability.presentation.dtos.SlotDto;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/slots")
public class DoctorAvailabilityController {

  private final DoctorAvailabilityService doctorAvailabilityService;
  private final SlotModelDtoConverter slotModelDtoConverter;

  public DoctorAvailabilityController(
      DoctorAvailabilityService doctorAvailabilityService,
      SlotModelDtoConverter slotModelDtoConverter) {
    this.doctorAvailabilityService = doctorAvailabilityService;
    this.slotModelDtoConverter = slotModelDtoConverter;
  }

  @GetMapping
  public ResponseEntity<List<SlotDto>> getSlots() {
    List<SlotDto> slots =
        slotModelDtoConverter.convertModelsToDtos(doctorAvailabilityService.getAllSlots());
    return ResponseEntity.ok(slots);
  }
}
