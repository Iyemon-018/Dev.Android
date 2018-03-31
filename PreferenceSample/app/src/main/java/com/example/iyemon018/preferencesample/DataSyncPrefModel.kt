package com.example.iyemon018.preferencesample

import com.os.operando.garum.annotations.Pref
import com.os.operando.garum.annotations.PrefKey
import com.os.operando.garum.models.PrefModel

@Pref
class DataSyncPrefModel : PrefModel() {

    @PrefKey("sync_frequency")
    public var syncFrequency: String = ""
}