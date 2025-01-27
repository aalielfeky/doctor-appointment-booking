package edu.dab.modules.doctor_appointment_management.internals.core.models;

import edu.dab.modules.shared.AppointmentStatusEnum;
import java.time.LocalDateTime;

public record DoctorAppointmentModel(LocalDateTime appointmentTime, AppointmentStatusEnum status) {}
