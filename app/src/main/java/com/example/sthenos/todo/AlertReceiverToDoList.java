package com.example.sthenos.todo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.sthenos.notification.NotificationHelper;

public class AlertReceiverToDoList extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder notifbuilder = notificationHelper.getChannelNotificationToDoList();
        notificationHelper.getManager().notify(963, notifbuilder.build());
    }
}
