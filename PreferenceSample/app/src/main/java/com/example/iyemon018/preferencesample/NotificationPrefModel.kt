package com.example.iyemon018.preferencesample

import com.os.operando.garum.annotations.Pref
import com.os.operando.garum.annotations.PrefKey
import com.os.operando.garum.models.PrefModel

@Pref
class NotificationPrefModel : PrefModel() {

    @PrefKey("notifications_new_message")
    public var notificationsNewMessage: Boolean = false

    @PrefKey("notifications_new_message_ringtone")
    public var notificationsNewMessageRingtone: String = ""

    @PrefKey("notifications_new_message_vibrate")
    public var notificationsNewMessageVibrate: Boolean = false
}
