package com.example.geneticscalculator;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.geneticscalculator.ui.MainActivity;

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
        createChannel();
        startForeground(notificationId, buildNoti());
        final WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        final WindowManager.LayoutParams params = new
                WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.TOP | Gravity.CENTER;
        View view1 = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.my_service, null);
        manager.addView(view1, params);
        manager.updateViewLayout(view1, params);
        view1.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                manager.removeView(view1);
                stopSelf();
            }
        });
    }

    public void createChannel()
    {
        NotificationChannel channel1 = new NotificationChannel(
                CHANNEL_ID2, "ServiseChannel", NotificationManager.IMPORTANCE_HIGH
        );
        channel1.setDescription("This is ServiceChannel");
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.createNotificationChannel(channel1);
    }

    public Notification buildNoti()
    {
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
        return notification;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
