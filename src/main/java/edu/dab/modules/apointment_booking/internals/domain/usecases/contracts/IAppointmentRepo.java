package edu.dab.modules.apointment_booking.internals.domain.usecases.contracts;

import edu.dab.modules.apointment_booking.internals.domain.models.AppointmentModel;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepo {
  List<AppointmentModel> getAppointments();
}
