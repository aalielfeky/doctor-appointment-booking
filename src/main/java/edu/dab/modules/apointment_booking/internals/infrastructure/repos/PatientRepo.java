package edu.dab.modules.apointment_booking.internals.infrastructure.repos;

import edu.dab.modules.apointment_booking.internals.infrastructure.entities.PatientEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class PatientRepo {
  private final List<PatientEntity> PATIENTS_ENTITIES =
      new ArrayList<>(
          List.of(
              PatientEntity.builder()
                  .id(UUID.fromString("8e7d9c4e-a5a2-445c-ba08-41fe88c15560"))
                  .patientName("PATIENT_1")
                  .build(),
              PatientEntity.builder()
                  .id(UUID.fromString("e026d966-94ce-4bca-bf23-72ba999837ed"))
                  .patientName("PATIENT_2")
                  .build(),
              PatientEntity.builder()
                  .id(UUID.fromString("12083570-6462-4cd4-baa2-3f2805945db4"))
                  .patientName("PATIENT_3")
                  .build()));
}
