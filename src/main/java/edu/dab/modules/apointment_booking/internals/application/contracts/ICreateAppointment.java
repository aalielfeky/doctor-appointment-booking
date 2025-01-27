package edu.dab.modules.apointment_booking.internals.application.contracts;

import edu.dab.modules.apointment_booking.internals.domain.models.AppointmentModel;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreateAppointment {
  UUID createAppointment(AppointmentModel appointmentModel);
}
