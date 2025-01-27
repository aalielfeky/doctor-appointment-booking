package edu.dab.modules.doctor_appointment_management.internals.shell.apis.dtos;

import edu.dab.modules.shared.AppointmentStatusEnum;

import java.time.LocalDateTime;

public record GetUpcomingAppointmentsDTO(
    LocalDateTime appointmentTime, AppointmentStatusEnum status) {}
