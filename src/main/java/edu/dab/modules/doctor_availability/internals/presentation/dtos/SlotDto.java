package edu.dab.modules.doctor_availability.internals.presentation.dtos;

public record SlotDto(String time, String doctorName, boolean isReserved, Double cost) {}
