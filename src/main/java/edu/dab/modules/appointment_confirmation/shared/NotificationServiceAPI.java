package edu.dab.modules.appointment_confirmation.shared;

import edu.dab.modules.appointment_confirmation.internals.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceAPI {

  private final NotificationService notificationService;

  public NotificationServiceAPI(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  public void notify(String message) {
    notificationService.sendNotification(message);
  }
}
