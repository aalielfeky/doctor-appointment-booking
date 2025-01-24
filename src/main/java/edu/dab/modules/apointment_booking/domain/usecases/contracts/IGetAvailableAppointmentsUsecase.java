package edu.dab.modules.apointment_booking.domain.usecases.contracts;

import edu.dab.modules.apointment_booking.domain.models.AppointmentModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IGetAvailableAppointmentsUsecase {
  List<AppointmentModel> getAppointments();
}
