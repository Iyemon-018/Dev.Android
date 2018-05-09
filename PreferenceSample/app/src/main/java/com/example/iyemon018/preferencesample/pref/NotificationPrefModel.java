package com.example.iyemon018.preferencesample.pref;

import com.os.operando.garum.annotations.Pref;
import com.os.operando.garum.annotations.PrefKey;
import com.os.operando.garum.models.PrefModel;

@Pref
public final class NotificationPrefModel extends PrefModel {
    
    @PrefKey("notifications_new_message")
    public boolean notificationsNewMessage;
    
    @PrefKey("notifications_new_message_ringtone")
    public String notificationsNewMessageRingtone;
    
    @PrefKey("notifications_new_message_vibrate")
    public boolean notificationsNewMessageVibrate;
}
