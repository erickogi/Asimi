package com.erickogi14gmail.asimi.Services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.content.WakefulBroadcastReceiver;

import com.erickogi14gmail.asimi.Data.DBOperations;
import com.erickogi14gmail.asimi.Data.DBPojo;

/**
 * Created by denis on 4/27/17.
 */

public class AlarmReciever extends WakefulBroadcastReceiver {
    DBPojo pojo;
    DBOperations mDBOperations;

    private AlarmManager mAlarmManager;
    private PendingIntent mAlarmIntent;

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, NotificationService.class);
        startWakefulService(context, service);
    }

    public void setAlarm(Context context){
        mDBOperations = new DBOperations(context);
        mAlarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent alarmIntent = new Intent(context, AlarmReciever.class);
        mAlarmIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);

        mDBOperations.getTimeList();
        long time = pojo.getREMAINDER_TIME();

        mAlarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, time, AlarmManager.INTERVAL_DAY, mAlarmIntent);

        ComponentName reciever = new ComponentName(context, BootReciever.class);
        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(reciever,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    public void cancelAlarm(Context context){
        if (mAlarmManager != null){
            mAlarmManager.cancel(mAlarmIntent);
        }

        ComponentName reciever = new ComponentName(context, BootReciever.class);
        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(reciever,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }
}
