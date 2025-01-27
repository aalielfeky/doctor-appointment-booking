package edu.dab.modules.apointment_booking.internals.application.dtos;

import lombok.NonNull;

public record AppointmentCreateRequest(@NonNull String slotId, @NonNull String patientId) {}
