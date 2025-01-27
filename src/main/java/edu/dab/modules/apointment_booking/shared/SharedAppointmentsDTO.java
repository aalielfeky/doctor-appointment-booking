package edu.dab.modules.apointment_booking.shared;

import edu.dab.modules.shared.AppointmentStatusEnum;
import java.time.LocalDateTime;
import java.util.UUID;

public record SharedAppointmentsDTO(
    UUID appointmentId, LocalDateTime appointmentTime, AppointmentStatusEnum status) {}
