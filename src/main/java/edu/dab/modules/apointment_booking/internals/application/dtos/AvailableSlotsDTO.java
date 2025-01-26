package edu.dab.modules.apointment_booking.internals.application.dtos;

import java.time.LocalDateTime;

public record AvailableSlotsDTO(String doctorName, LocalDateTime startDate, Double cost) {}
