package com.example.iyemon018.preferencesample.pref;

/**
 * Created by iyemon018 on 2018/03/31.
 */
public final class AppPref {
    
    public final DataSyncPrefModel dataSync;
    
    public final GeneralPrefModel general;
    
    public final NotificationPrefModel notification;
    
    public AppPref() {
        
        dataSync = new DataSyncPrefModel();
        notification = new NotificationPrefModel();
        general = new GeneralPrefModel();
    }
}
