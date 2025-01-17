package edu.dab.modules.doctor_availability.business.services;

import edu.dab.modules.doctor_availability.business.converters.SlotEntityModelConverter;
import edu.dab.modules.doctor_availability.business.models.SlotModel;
import edu.dab.modules.doctor_availability.data.repos.SlotRepo;
import java.util.List;
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
}
