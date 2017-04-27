package com.erickogi14gmail.asimi.Services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by denis on 4/27/17.
 */

public class BootReciever extends BroadcastReceiver {
    AlarmReciever alarmReciever = new AlarmReciever();

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")){
                alarmReciever.setAlarm(context);
        }
    }
}
