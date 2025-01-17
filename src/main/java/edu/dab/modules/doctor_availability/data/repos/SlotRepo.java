package edu.dab.modules.doctor_availability.data.repos;

import edu.dab.modules.doctor_availability.data.entities.SlotEntity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class SlotRepo {
  private static final List<SlotEntity> slotEntities =
      List.of(
          new SlotEntity(
              UUID.randomUUID(),
              LocalDateTime.now().plusHours(1L),
              UUID.fromString("a781f4a5-34d0-4dcf-b715-4f4f3d61e330"),
              "Doc1",
              false,
              Double.valueOf("200")),
          new SlotEntity(
              UUID.randomUUID(),
              LocalDateTime.now().plusHours(2L),
              UUID.fromString("a781f4a5-34d0-4dcf-b715-4f4f3d61e330"),
              "Doc1",
              true,
              Double.valueOf("200")),
          new SlotEntity(
              UUID.randomUUID(),
              LocalDateTime.now().plusHours(3L),
              UUID.fromString("a781f4a5-34d0-4dcf-b715-4f4f3d61e330"),
              "Doc1",
              false,
              Double.valueOf("200")));

  public List<SlotEntity> findAllSlots() {
    return slotEntities;
  }
}
