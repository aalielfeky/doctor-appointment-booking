package edu.dab.modules.apointment_booking.application.converters;

import edu.dab.modules.apointment_booking.application.dtos.AppointmentDto;
import edu.dab.modules.apointment_booking.domain.models.AppointmentModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AppointmentConverter {

  public List<AppointmentDto> convertToDtos(List<AppointmentModel> appointmentModels) {
    return appointmentModels.stream().map(this::mapModelToDto).toList();
  }

  private AppointmentDto mapModelToDto(AppointmentModel appointmentModel) {
    AppointmentDto dto = null;
    // TODO: impl
    return dto;
  }
}
