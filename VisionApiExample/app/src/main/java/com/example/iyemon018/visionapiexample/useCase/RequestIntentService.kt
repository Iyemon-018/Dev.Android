package com.example.iyemon018.visionapiexample.useCase

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore

/**
 * Created by iyemon018 on 2018/05/10.
 */
class RequestIntentService(private val activity: Activity) : RequestService {

    companion object {
        const val TAKE_PICTURE_REQUEST_CODE = 12123
    }

    override fun toTakePicture() {
        val intent = getIntent(MediaStore.ACTION_IMAGE_CAPTURE)
        this.activity.startActivityForResult(intent, TAKE_PICTURE_REQUEST_CODE)
    }

    private fun getIntent(action: String) : Intent {
        return Intent(action)
    }
}