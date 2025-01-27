package edu.dab.modules.doctor_availability.shared;

import edu.dab.modules.doctor_availability.internals.data.entities.SlotEntity;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
class SharedDoctorAvailableSlotsDTOMapper {

  public List<SharedDoctorAvailableSlotsDTO> convertEntitiesToDTOs(List<SlotEntity> entities) {
    return entities.stream().map(this::convertEntityToDTO).toList();
  }

  public SharedDoctorAvailableSlotsDTO convertEntityToDTO(SlotEntity entity) {
    return new SharedDoctorAvailableSlotsDTO(
        entity.getId(), entity.getDoctorName(), entity.getTime(), entity.getCost());
  }
}
