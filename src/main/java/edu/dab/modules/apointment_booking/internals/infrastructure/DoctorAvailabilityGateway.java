package edu.dab.modules.apointment_booking.internals.infrastructure;

import edu.dab.modules.apointment_booking.internals.application.contracts.IGetDoctorAvailableSlots;
import edu.dab.modules.apointment_booking.internals.application.dtos.AvailableSlotsDTO;
import edu.dab.modules.doctor_availability.shared.DoctorAvailabilityAPI;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DoctorAvailabilityGateway implements IGetDoctorAvailableSlots {

  private final DoctorAvailabilityAPI doctorAvailabilityAPI;

  public DoctorAvailabilityGateway(DoctorAvailabilityAPI doctorAvailabilityAPI) {
    this.doctorAvailabilityAPI = doctorAvailabilityAPI;
  }

  @Override
  public List<AvailableSlotsDTO> getAvailableSlots() {
    return doctorAvailabilityAPI.getDoctorAvailableSlots().stream()
        .map(dto -> new AvailableSlotsDTO(dto.doctorName(), dto.startDate(), dto.cost()))
        .toList();
  }
}
