package edu.dab.modules.doctor_availability.data.entities;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SlotEntity {
  private UUID id;
  private LocalDateTime time;
  private UUID doctorId;
  private String doctorName;
  private boolean isReserved;
  private Double cost;

  public SlotEntity() {}

  @Builder
  public SlotEntity(
      UUID id,
      LocalDateTime time,
      UUID doctorId,
      String doctorName,
      boolean isReserved,
      Double cost) {
    this.id = id;
    this.time = time;
    this.doctorId = doctorId;
    this.doctorName = doctorName;
    this.isReserved = isReserved;
    this.cost = cost;
  }
}
