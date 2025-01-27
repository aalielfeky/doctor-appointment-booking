package edu.dab.modules.doctor_availability.internals.data.repos;

import edu.dab.modules.doctor_availability.internals.data.entities.SlotEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class SlotRepo {

  private final List<SlotEntity> SLOT_ENTITIES =
      new ArrayList<>(
          List.of(
              SlotEntity.builder()
                  .id(UUID.randomUUID())
                  .time(LocalDateTime.now().plusHours(1L))
                  .doctorId(UUID.fromString("a781f4a5-34d0-4dcf-b715-4f4f3d61e330"))
                  .doctorName("Doc1")
                  .isReserved(false)
                  .cost(Double.valueOf("200"))
                  .build(),
              SlotEntity.builder()
                  .id(UUID.randomUUID())
                  .time(LocalDateTime.now().plusHours(2L))
                  .doctorId(UUID.fromString("a781f4a5-34d0-4dcf-b715-4f4f3d61e330"))
                  .doctorName("Doc1")
                  .isReserved(true)
                  .cost(Double.valueOf("200"))
                  .build(),
              SlotEntity.builder()
                  .id(UUID.randomUUID())
                  .time(LocalDateTime.now().plusHours(3L))
                  .doctorId(UUID.fromString("a781f4a5-34d0-4dcf-b715-4f4f3d61e330"))
                  .doctorName("Doc1")
                  .isReserved(false)
                  .cost(Double.valueOf("200"))
                  .build()));

  public List<SlotEntity> findAllSlots() {
    return SLOT_ENTITIES;
  }

  public UUID saveSlot(SlotEntity slotEntity) {
    UUID slotId = UUID.randomUUID();
    slotEntity.setId(slotId);
    // manage only one doctor
    slotEntity.setDoctorId(UUID.fromString("a781f4a5-34d0-4dcf-b715-4f4f3d61e330"));
    SLOT_ENTITIES.add(slotEntity);
    return slotId;
  }

  public List<SlotEntity> findAvailableSlots() {
    return SLOT_ENTITIES.stream().filter(slot -> !slot.isReserved()).toList();
  }

  public void reserveSlot(UUID slotId) {
    SLOT_ENTITIES.stream()
        .filter(slot -> slot.getId().equals(slotId))
        .findFirst()
        .ifPresent(slot -> slot.setReserved(true));
    // TODO: handle exceptional flow
  }
}
