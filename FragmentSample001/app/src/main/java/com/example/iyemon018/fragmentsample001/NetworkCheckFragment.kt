package com.example.iyemon018.fragmentsample001


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.LocalBroadcastManager
import android.widget.Toast

/**
 * ネットワークの接続状態を検知するための[Fragment] クラスです。
 * この[Fragment] はUI を持ちません。
 *
 */
class NetworkCheckFragment : Fragment() {
    companion object {
        const val ACTION_CHECK_INTERNET = "ACTION_CHECK_INTERNET"
        const val KEY_CHECK_INTERNET = "KEY_CHECK_INTERNET"

        fun isConnected(context: Context?): Boolean {
            return isWifiConnected(context) || isMobileConnected(context)
        }

        private fun isMobileConnected(context: Context?): Boolean {
            val manager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = manager?.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
            return info?.isConnected ?: false
        }

        private fun isWifiConnected(context: Context?): Boolean {
            val manager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = manager?.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
            return info?.isConnected ?: false
        }
    }

    private val receiver: BroadcastReceiver = object: BroadcastReceiver(){
        /**
         * This method is called when the BroadcastReceiver is receiving an Intent
         * broadcast.  During this time you can use the other methods on
         * BroadcastReceiver to view/modify the current result values.  This method
         * is always called within the main thread of its process, unless you
         * explicitly asked for it to be scheduled on a different thread using
         * [android.content.Context.registerReceiver]. When it runs on the main
         * thread you should
         * never perform long-running operations in it (there is a timeout of
         * 10 seconds that the system allows before considering the receiver to
         * be blocked and a candidate to be killed). You cannot launch a popup dialog
         * in your implementation of onReceive().
         *
         *
         * **If this BroadcastReceiver was launched through a &lt;receiver&gt; tag,
         * then the object is no longer alive after returning from this
         * function.** This means you should not perform any operations that
         * return a result to you asynchronously. If you need to perform any follow up
         * background work, schedule a [android.app.job.JobService] with
         * [android.app.job.JobScheduler].
         *
         * If you wish to interact with a service that is already running and previously
         * bound using [bindService()][android.content.Context.bindService],
         * you can use [.peekService].
         *
         *
         * The Intent filters used in [android.content.Context.registerReceiver]
         * and in application manifests are *not* guaranteed to be exclusive. They
         * are hints to the operating system about how to find suitable recipients. It is
         * possible for senders to force delivery to specific recipients, bypassing filter
         * resolution.  For this reason, [onReceive()][.onReceive]
         * implementations should respond only to known actions, ignoring any unexpected
         * Intents that they may receive.
         *
         * @param context The Context in which the receiver is running.
         * @param intent The Intent being received.
         */
        override fun onReceive(context: Context?, intent: Intent?) {

            // ブロードキャストの通知を受け取ると、トーストを表示する。
            // ここではNetworkStateReceiver を設定するので接続状態が取得できる。
            val action = intent?.action
            if (ACTION_CHECK_INTERNET == action) {
                val isConnected = intent.getBooleanExtra(KEY_CHECK_INTERNET, false)
                val message = if (isConnected) "インターネット接続あり" else "インターネット接続なし"
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private var intentFilter: IntentFilter? = null

    override fun onResume() {
        super.onResume()

        if (intentFilter == null) {
            intentFilter = IntentFilter(ACTION_CHECK_INTERNET)
        }

        LocalBroadcastManager.getInstance(this.context!!).registerReceiver(receiver, this.intentFilter!!)
    }

    override fun onPause() {
        super.onPause()

        LocalBroadcastManager.getInstance(context!!).unregisterReceiver(receiver)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 以下を true に設定することでFragment の再構築を防ぐ。
        // ここでいう再構築とはonCreate / onDestroy が呼ばれなくなるということ。
        // onAttach / onDetach / onCreateView は呼ばれるので注意する。
        // この手法は画面回転時などにFragment の再構築をしたくない場合に使用される。
        // リファレンス : https://developer.android.com/reference/android/app/Fragment.html#setRetainInstance(boolean)
        retainInstance = true
    }
}
