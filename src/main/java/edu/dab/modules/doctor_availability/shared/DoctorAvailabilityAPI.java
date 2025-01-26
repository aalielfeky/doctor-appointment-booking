package edu.dab.modules.doctor_availability.shared;

import edu.dab.modules.doctor_availability.internals.data.repos.SlotRepo;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DoctorAvailabilityAPI {
  private final SlotRepo slotRepo;
  private final SharedDoctorAvailableSlotsDTOMapper sharedDoctorAvailableSlotsDTOMapper;

  public DoctorAvailabilityAPI(
      SlotRepo slotRepo, SharedDoctorAvailableSlotsDTOMapper sharedDoctorAvailableSlotsDTOMapper) {
    this.slotRepo = slotRepo;
    this.sharedDoctorAvailableSlotsDTOMapper = sharedDoctorAvailableSlotsDTOMapper;
  }

  public List<SharedDoctorAvailableSlotsDTO> getDoctorAvailableSlots() {
    return sharedDoctorAvailableSlotsDTOMapper.convertEntitiesToDTOs(slotRepo.findAvailableSlots());
  }
}
