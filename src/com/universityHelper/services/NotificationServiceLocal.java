package com.universityHelper.services;

import javax.ejb.Local;

@Local
public interface NotificationServiceLocal {

	boolean deleteNotification(String notificationId);

}
