package com.example.sthenos.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder notifbuilder = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(999, notifbuilder.build());
    }
}
