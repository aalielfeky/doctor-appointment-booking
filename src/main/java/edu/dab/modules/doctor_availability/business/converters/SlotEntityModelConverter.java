package edu.dab.modules.doctor_availability.business.converters;

import edu.dab.modules.doctor_availability.business.models.SlotModel;
import edu.dab.modules.doctor_availability.data.entities.SlotEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SlotEntityModelConverter {

  public List<SlotModel> convertEntitiesToModels(List<SlotEntity> allSlots) {
    List<SlotModel> slotModels = new ArrayList<>();
    allSlots.forEach(slotEntity -> slotModels.add(toModel(slotEntity)));
    return slotModels;
  }

  public SlotModel toModel(SlotEntity slotEntity) {
    return new SlotModel(slotEntity.doctorName());
  }
}
