package edu.dab.modules.doctor_availability.internals.business.services;

import edu.dab.modules.doctor_availability.internals.business.converters.SlotEntityModelConverter;
import edu.dab.modules.doctor_availability.internals.business.models.SlotModel;
import edu.dab.modules.doctor_availability.internals.data.repos.SlotRepo;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DoctorAvailabilityService {

  private final SlotRepo slotRepo;
  private final SlotEntityModelConverter slotConverter;

  public DoctorAvailabilityService(SlotRepo slotRepo, SlotEntityModelConverter slotConverter) {
    this.slotRepo = slotRepo;
    this.slotConverter = slotConverter;
  }

  public List<SlotModel> getAllSlots() {
    return slotConverter.convertEntitiesToModels(slotRepo.findAllSlots());
  }

  public UUID createSlot(SlotModel slotModel) {
    return slotRepo.saveSlot(slotConverter.convertModelToEntity(slotModel));
  }
}
