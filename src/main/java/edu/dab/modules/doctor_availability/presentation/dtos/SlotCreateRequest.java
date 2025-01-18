package edu.dab.modules.doctor_availability.presentation.dtos;

public record SlotCreateRequest(String time, String doctorName, boolean isReserved, Double cost) {}
