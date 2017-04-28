package com.erickogi14gmail.asimi.Services;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.erickogi14gmail.asimi.AddRemainder.AddTimeRemainder;
import com.erickogi14gmail.asimi.R;

/**
 * Created by denis on 4/27/17.
 */

public class NotificationService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public NotificationService( String name,int id, String mtitle, String mMessage) {
        super(name);
        sendTimeNotification(id, mtitle, mMessage);

    }


    private NotificationManager mNotificationManager;
    NotificationCompat.Builder builder;

    @Override
    protected void onHandleIntent(Intent intent) {

        AlarmReciever.startWakefulService( this,intent);
    }

    private void sendTimeNotification(int mId, String title, String message){
        builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setContentTitle(title)
                .setContentText(message);

        Intent resultIntent = new Intent(this, AddTimeRemainder.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        stackBuilder.addParentStack(AddTimeRemainder.class);

        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(resultPendingIntent);
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(mId, builder.build());

    }
}
