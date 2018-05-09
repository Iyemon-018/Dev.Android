package com.example.iyemon018.preferencesample.pref;

import com.os.operando.garum.annotations.Pref;
import com.os.operando.garum.annotations.PrefKey;
import com.os.operando.garum.models.PrefModel;

@Pref
public final class DataSyncPrefModel extends PrefModel {
    
    @PrefKey("sync_frequency")
    public String syncFrequency;
    
}
