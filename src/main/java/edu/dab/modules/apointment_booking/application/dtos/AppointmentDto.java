package edu.dab.modules.apointment_booking.application.dtos;

import java.time.LocalDateTime;

public record AppointmentDto(
    String doctorName, LocalDateTime from, LocalDateTime to, Double cost) {}
