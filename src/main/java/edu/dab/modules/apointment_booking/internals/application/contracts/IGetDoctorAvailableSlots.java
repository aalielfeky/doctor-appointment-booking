package edu.dab.modules.apointment_booking.internals.application.contracts;

import edu.dab.modules.apointment_booking.internals.application.dtos.AvailableSlotsDTO;
import java.util.List;

public interface IGetDoctorAvailableSlots {
  List<AvailableSlotsDTO> getAvailableSlots();
}
