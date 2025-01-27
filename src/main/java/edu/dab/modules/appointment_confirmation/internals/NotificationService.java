package edu.dab.modules.appointment_confirmation.internals;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
  public void sendNotification(String message) {
    System.out.println(message);
  }
}
