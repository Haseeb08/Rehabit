package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.entities.Notification;

import java.util.List;

public interface NotificationService {

    List<Notification> findAllNotifications();
    Notification findById(int id);
    void save(Notification notification);
    void deleteById(int id);
}
