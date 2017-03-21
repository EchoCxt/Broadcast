package com.example.zxdn.lab_4;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by zxdn on 2016/10/23.
 */
public class StaticReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
           if (intent.getAction().equals("Static")) {
               Bundle bundle= intent.getExtras();
               String mas= bundle.getString("name");
               int pho= bundle.getInt("photo");
               Bitmap bm = BitmapFactory.decodeResource(context.getResources(),pho);

               NotificationManager manager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
               Notification.Builder builder= new Notification.Builder(context);
                   builder.setContentTitle("静态广播")
                           .setContentText(mas)
                           .setLargeIcon(bm)
                           .setSmallIcon(pho)
                           .setTicker("您有一条新信息")
                           .setAutoCancel(true);

               Intent mIntent= new Intent(context, main_activity.class);
               PendingIntent mPending = PendingIntent.getActivity(context, 0, mIntent, 0);
               builder.setContentIntent(mPending);
               Notification notify =builder.build();
               manager.notify(0,notify);

           }
    }
}
