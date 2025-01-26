package edu.dab.modules.apointment_booking.internals.repos;

import edu.dab.modules.apointment_booking.internals.domain.models.AppointmentModel;
import edu.dab.modules.apointment_booking.internals.domain.usecases.contracts.IAppointmentRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentRepo implements IAppointmentRepo {
    @Override
    public List<AppointmentModel> getAppointments() {
        // TODO: call from doctor availability module
        return List.of();
    }
}
