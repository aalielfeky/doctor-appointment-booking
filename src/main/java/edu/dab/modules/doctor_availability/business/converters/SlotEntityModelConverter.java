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

  public SlotModel toModel(SlotEntity entity) {
    return new SlotModel(
        entity.getTime(), entity.getDoctorName(), entity.isReserved(), entity.getCost());
  }

  public SlotEntity convertModelToEntity(SlotModel model) {
    SlotEntity entity = new SlotEntity();
    entity.setTime(model.time());
    entity.setDoctorName(model.doctorName());
    entity.setReserved(model.isReserved());
    entity.setCost(model.cost());
    return entity;
  }
}
