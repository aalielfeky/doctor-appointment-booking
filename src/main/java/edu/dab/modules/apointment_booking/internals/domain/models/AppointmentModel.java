package edu.dab.modules.apointment_booking.internals.domain.models;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class AppointmentModel {
    private UUID appointmentId;
    private UUID slotId;
    private UUID patientId;
    private String patientName;
    private LocalDateTime reservedAt;
}
