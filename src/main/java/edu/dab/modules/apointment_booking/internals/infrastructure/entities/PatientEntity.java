package edu.dab.modules.apointment_booking.internals.infrastructure.entities;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientEntity {
  private UUID id;
  private String patientName;

  @Builder
  public PatientEntity(UUID id, String patientName) {
    this.id = id;
    this.patientName = patientName;
  }
}
