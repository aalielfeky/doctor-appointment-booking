package edu.dab.modules.doctor_availability.shared;

import edu.dab.modules.doctor_availability.internals.data.entities.SlotEntity;
import edu.dab.modules.doctor_availability.internals.data.repos.SlotRepo;
import java.util.List;
import java.util.UUID;
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

  public void reserveSlot(UUID slotId) {
    slotRepo.reserveSlot(slotId);
  }

  public SharedDoctorAvailableSlotsDTO getSlotById(UUID slotId) {
    SlotEntity slotEntity = slotRepo.findSlotById(slotId);
    return sharedDoctorAvailableSlotsDTOMapper.convertEntityToDTO(slotEntity);
  }
}
