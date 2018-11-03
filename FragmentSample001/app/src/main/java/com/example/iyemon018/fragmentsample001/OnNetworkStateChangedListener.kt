package com.example.iyemon018.fragmentsample001

import android.content.Context

/**
 * Created by iyemon018 on 2018/11/04.
 */
interface OnNetworkStateChangedListener {
    fun isConnected(context: Context?) : Boolean
}