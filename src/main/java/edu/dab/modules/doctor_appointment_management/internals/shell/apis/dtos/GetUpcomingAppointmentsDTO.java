package edu.dab.modules.doctor_appointment_management.internals.shell.apis.dtos;

import edu.dab.modules.shared.AppointmentStatusEnum;
import java.time.LocalDateTime;
import java.util.UUID;

public record GetUpcomingAppointmentsDTO(
    UUID appointmentId, LocalDateTime appointmentTime, AppointmentStatusEnum status) {}
