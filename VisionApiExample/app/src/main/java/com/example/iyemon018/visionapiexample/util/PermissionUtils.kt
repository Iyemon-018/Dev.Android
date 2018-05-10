package com.example.iyemon018.visionapiexample.util

import android.app.Activity
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

/**
 * Created by Kishii on 2018/05/10.
 */
class PermissionUtils {
    companion object {
        fun requestPermission(activity: Activity, requestCode: Int, vararg permissions: String) : Boolean {
            var granded = true
            val permissionNeeded = ArrayList<String>()


            for (s :String in permissions) {
                val permissionCheck = ContextCompat.checkSelfPermission(activity, s)
                val hasPermission = (permissionCheck == PackageManager.PERMISSION_GRANTED)

                if (!hasPermission) {
                    permissionNeeded.add(s)
                    granded = false
                }
            }

            return if (granded) {
                true
            } else {
                ActivityCompat.requestPermissions(activity, permissionNeeded.toTypedArray(), requestCode)
                false
            }
        }

        fun permissionGranted(requestCode: Int, permissionCode: Int, grantResults: IntArray) : Boolean {
            return requestCode == permissionCode && grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
        }
    }
}