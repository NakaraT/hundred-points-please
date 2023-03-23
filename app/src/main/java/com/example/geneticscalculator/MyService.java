package com.example.geneticscalculator;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyService extends Service {
    private String CHANNEL_ID2 = "ServiceChannel";
    public final int notificationId = 2;

    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        NotificationChannel channel1 = new NotificationChannel(
                CHANNEL_ID2, "ServiseChannel", NotificationManager.IMPORTANCE_HIGH);
        channel1.setDescription("This is ServiceChannel");
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.createNotificationChannel(channel1);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID2)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(getString(R.string.notification_title_2))
                .setContentText(getString(R.string.notification_text_2))
                .setChannelId(CHANNEL_ID2)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_LOW);
        Intent resultIntent = new Intent(getApplicationContext(), MyService.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, resultIntent, 0);
        builder.setContentIntent(resultPendingIntent);
        Notification notification = builder.build();
        startForeground(notificationId, notification);

    }

    public void onDestroy() {
        super.onDestroy();
    }
}