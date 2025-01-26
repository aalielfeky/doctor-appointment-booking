package edu.dab.modules.doctor_availability.internals.presentation.converters;

import edu.dab.modules.doctor_availability.internals.business.models.SlotModel;
import edu.dab.modules.doctor_availability.internals.presentation.dtos.SlotCreateRequest;
import edu.dab.modules.doctor_availability.internals.presentation.dtos.SlotDto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SlotModelConverter {

  private final DateTimeFormatter TIME_FORMATTER =
      DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");

  public List<SlotDto> convertModelsToDtos(List<SlotModel> models) {
    List<SlotDto> dtos = new ArrayList<>();
    for (SlotModel model : models) {
      String formattedTime = model.time().format(TIME_FORMATTER);
      dtos.add(new SlotDto(formattedTime, model.doctorName(), model.isReserved(), model.cost()));
    }
    return dtos;
  }

  public SlotModel convertToModel(SlotCreateRequest slotCreateRequest) {
    return new SlotModel(
        LocalDateTime.parse(slotCreateRequest.time(), TIME_FORMATTER),
        slotCreateRequest.doctorName(),
        slotCreateRequest.isReserved(),
        slotCreateRequest.cost());
  }
}
