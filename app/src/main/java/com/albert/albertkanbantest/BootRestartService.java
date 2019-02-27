package com.albert.albertkanbantest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by liuc on 2017-05-04.
 * 主要内容：开机启动广播
 */

public class BootRestartService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("TAG", "BootRestartService: " + System.currentTimeMillis());
        try {
            Thread.sleep(6000);
            Intent i = new Intent(context, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Log.e("TAG", "intent: " + System.currentTimeMillis());
            context.startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
