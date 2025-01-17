package edu.dab.modules.doctor_availability.data.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public record SlotEntity(
    UUID id,
    LocalDateTime date,
    UUID doctorId,
    String doctorName,
    boolean isReserved,
    Double cost) {}
