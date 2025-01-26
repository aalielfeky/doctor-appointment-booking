package edu.dab.modules.apointment_booking.internals.application.dtos;

import java.time.LocalDateTime;

public record AppointmentDto(
    String doctorName, LocalDateTime from, LocalDateTime to, Double cost) {}
