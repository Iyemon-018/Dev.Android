package com.example.iyemon018.preferencesample

import android.app.Application

/**
 * Created by iyemon018 on 2018/03/23.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val builder = com.os.operando.garum.Configuration.Builder(applicationContext)
        builder.setModelClasses(DataSyncPrefModel::class.java
                            , GeneralPrefModel::class.java
                            , NotificationPrefModel::class.java)
        com.os.operando.garum.Garum.initialize(builder.create(), false)

        val appSettings = AppSettings()

        appSettings.general.exampleText = "this is test for 2018/03/31"
        appSettings.general.apply()
    }
}