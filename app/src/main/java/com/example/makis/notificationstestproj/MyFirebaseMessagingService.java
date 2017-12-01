package com.example.makis.notificationstestproj;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.media.SoundPool;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

/**
 * Created by makis on 23/11/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    static int id = 0;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intent intent=new Intent(this,SecondActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent= PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        Gson myGson=new Gson();
        String myJson = myGson.toJson(remoteMessage.getData());
        intent.putExtra("myjson", myJson);
        NotificationCompat.Builder notificationBuilder=new NotificationCompat.Builder(this,"1");
        notificationBuilder.setContentTitle(remoteMessage.getNotification().getTitle());
        notificationBuilder.setContentText(remoteMessage.getNotification().getBody());
        notificationBuilder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notificationBuilder.setContentIntent(pendingIntent);

        NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        id++;
        notificationManager.notify("app",id,notificationBuilder.build());
    }
}
