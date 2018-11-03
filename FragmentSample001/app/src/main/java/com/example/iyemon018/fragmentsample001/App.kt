package com.example.iyemon018.fragmentsample001

import android.app.Application
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build

/**
 * Created by iyemon018 on 2018/11/04.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        // Nougat 以降のOS では、manifest に接続状態の監視アクションを設定しても無視される。
        // そのため、この時点でインテントフィルターを設定しておく。
        // これをしないと、ネットワークの接続状態を検知できない。
        // 参考 : https://qiita.com/ShingoFukuyama/items/459847ee26e0733f377d
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerReceiver(NetworkStateReceiver(), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        }
    }
}