package edu.dab.modules.doctor_availability.presentation.converters;

import edu.dab.modules.doctor_availability.business.models.SlotModel;
import edu.dab.modules.doctor_availability.presentation.dtos.SlotDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SlotModelDtoConverter {

  public List<SlotDto> convertModelsToDtos(List<SlotModel> allSlots) {
    List<SlotDto> slotDtos = new ArrayList<>();
    for (SlotModel slotModel : allSlots) {
      slotDtos.add(new SlotDto(slotModel.doctorName()));
    }
    return slotDtos;
  }
}
