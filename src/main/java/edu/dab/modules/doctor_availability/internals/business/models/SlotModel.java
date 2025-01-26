package edu.dab.modules.doctor_availability.internals.business.models;

import java.time.LocalDateTime;

public record SlotModel(LocalDateTime time, String doctorName, boolean isReserved, Double cost) {}
