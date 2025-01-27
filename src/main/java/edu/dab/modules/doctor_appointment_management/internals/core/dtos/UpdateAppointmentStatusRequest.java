package edu.dab.modules.doctor_appointment_management.internals.core.dtos;

import edu.dab.modules.shared.AppointmentStatusEnum;

public record UpdateAppointmentStatusRequest(
    String appointmentId, AppointmentStatusEnum newStatus) {}
