package edu.dab.modules.apointment_booking.internals.application.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record AvailableSlotsDTO(
    UUID slotId, String doctorName, LocalDateTime startDate, Double cost) {}
