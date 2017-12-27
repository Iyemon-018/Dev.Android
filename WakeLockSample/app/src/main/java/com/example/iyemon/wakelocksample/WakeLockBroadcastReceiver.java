package com.example.iyemon.wakelocksample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by i_m_a on 2017/12/28.
 */

public final class WakeLockBroadcastReceiver extends BroadcastReceiver {

    private WakeLockListener listener;

    public WakeLockBroadcastReceiver(WakeLockListener listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_SCREEN_ON)) {
            this.listener.onScreenOn();
        } else if (action.equals(Intent.ACTION_SCREEN_OFF)) {
            this.listener.onScreenOff();
        }
    }
}
