package com.example.zxdn.lab_4;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

/**
 * Created by zxdn on 2016/10/23.
 */
public class dynamicReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("TheDynamic")) {
            Bundle bundle= intent.getExtras();
            Bitmap bm= BitmapFactory.decodeResource(context.getResources(),R.mipmap.dynamic);
            NotificationManager manager= (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            Notification.Builder builder = new Notification.Builder(context);
            builder.setContentTitle("动态广播")
                    .setContentText(bundle.getString("massage"))
                    .setTicker("您有一条新信息")
                    .setLargeIcon(bm)
                    .setSmallIcon(R.mipmap.dynamic)
                    .setAutoCancel(true);
            Intent mIntent= new Intent(context, main_activity.class);
            PendingIntent mPending = PendingIntent.getActivity(context, 0, mIntent, 0);
            builder.setContentIntent(mPending);
            Notification notify =builder.build();
            manager.notify(0,notify);

        }
    }
}
