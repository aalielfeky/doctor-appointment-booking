package edu.dab.modules.doctor_availability.shared;

import java.time.LocalDateTime;

public record SharedDoctorAvailableSlotsDTO(
    String doctorName, LocalDateTime startDate, Double cost) {}
