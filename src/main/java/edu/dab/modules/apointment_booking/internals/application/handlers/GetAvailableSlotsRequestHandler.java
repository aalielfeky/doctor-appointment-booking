package edu.dab.modules.apointment_booking.internals.application.handlers;

import edu.dab.modules.apointment_booking.internals.application.contracts.IGetDoctorAvailableSlots;
import edu.dab.modules.apointment_booking.internals.application.dtos.AvailableSlotsDTO;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetAvailableSlotsRequestHandler {
  private final IGetDoctorAvailableSlots getDoctorAvailableSlots;

  public GetAvailableSlotsRequestHandler(IGetDoctorAvailableSlots getDoctorAvailableSlots) {
    this.getDoctorAvailableSlots = getDoctorAvailableSlots;
  }

  public List<AvailableSlotsDTO> handleGetAvailableSlots() {
    return getDoctorAvailableSlots.getAvailableSlots();
  }
}
