package edu.dab.modules.doctor_availability.shared;

import java.time.LocalDateTime;
import java.util.UUID;

public record SharedDoctorAvailableSlotsDTO(
    UUID slotId, String doctorName, LocalDateTime startDate, Double cost) {}
