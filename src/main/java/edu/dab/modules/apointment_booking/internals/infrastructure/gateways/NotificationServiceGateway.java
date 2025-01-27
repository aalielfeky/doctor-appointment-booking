package edu.dab.modules.apointment_booking.internals.infrastructure.gateways;

import edu.dab.modules.apointment_booking.internals.application.contracts.INotificationConfirmationService;
import edu.dab.modules.appointment_confirmation.shared.NotificationServiceAPI;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceGateway implements INotificationConfirmationService {

  private final NotificationServiceAPI notificationServiceAPI;

  public NotificationServiceGateway(NotificationServiceAPI notificationServiceAPI) {
    this.notificationServiceAPI = notificationServiceAPI;
  }

  @Override
  public void sendAppointmentNotification(String message) {
    notificationServiceAPI.notify(message);
  }
}
