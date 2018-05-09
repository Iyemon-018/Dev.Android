package com.example.iyemon018.preferencesample;

import android.app.Application;

import com.os.operando.garum.Configuration;
import com.os.operando.garum.Garum;

/**
 * Created by iyemon018 on 2018/03/31.
 */
public final class MyApp extends Application {
    
    @Override
    public void onCreate() {
        
        super.onCreate();
        
        Configuration.Builder builder = new Configuration.Builder(this);
        builder.setModelClasses(com.example.iyemon018.preferencesample.pref.DataSyncPrefModel.class
                                , com.example.iyemon018.preferencesample.pref.GeneralPrefModel.class
                                , com.example.iyemon018.preferencesample.pref.NotificationPrefModel.class);
        Garum.initialize(builder.create(), false);
        
        
        
        
    }
}
