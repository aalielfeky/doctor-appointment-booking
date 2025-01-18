package edu.dab.modules.doctor_availability.business.models;

import java.time.LocalDateTime;

public record SlotModel(LocalDateTime time, String doctorName, boolean isReserved, Double cost) {}
