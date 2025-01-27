package edu.dab.modules.apointment_booking.shared;

import edu.dab.modules.apointment_booking.internals.infrastructure.repos.AppointmentRepo;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AppointmentsAPI {
  private final AppointmentRepo appointmentRepo;

  public AppointmentsAPI(AppointmentRepo appointmentRepo) {
    this.appointmentRepo = appointmentRepo;
  }

  public List<SharedAppointmentsDTO> getAllAppointments() {
    return appointmentRepo.getAllAppointments().stream()
        .map(entity -> new SharedAppointmentsDTO(entity.getAppointmentTime(), entity.getStatus()))
        .toList();
  }
}
