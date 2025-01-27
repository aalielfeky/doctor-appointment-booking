package edu.dab.modules.apointment_booking.shared;

import edu.dab.modules.shared.AppointmentStatusEnum;
import java.time.LocalDateTime;

public record SharedAppointmentsDTO(LocalDateTime appointmentTime, AppointmentStatusEnum status) {}
