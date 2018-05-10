package com.example.iyemon018.visionapiexample.useCase

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import com.example.iyemon018.visionapiexample.util.PermissionUtils
import java.io.File

/**
 * Created by iyemon018 on 2018/05/10.
 */
class RequestIntentService(private val activity: Activity) : RequestService {
    companion object {
        const val IMAGE_TEMP_FILE_NAME = "temp.jpg"
        const val TAKE_PICTURE_REQUEST_CODE = 12123
    }

    override fun toTakePicture() {
        if (PermissionUtils.requestPermission(this.activity, TAKE_PICTURE_REQUEST_CODE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA)) {
            val intent = getIntent(MediaStore.ACTION_IMAGE_CAPTURE)
            val photoUri = FileProvider.getUriForFile(this.activity, this.activity.applicationContext.packageName + ".provider", getCameraFile())
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            this.activity.startActivityForResult(intent, TAKE_PICTURE_REQUEST_CODE)
        }
    }

    override fun getPictureUri(): Uri {
        return FileProvider.getUriForFile(this.activity, this.activity.applicationContext.packageName + ".provider", getCameraFile())
    }

    private fun getCameraFile(): File {
        val dir = this.activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val imageDir = File(dir, "images")
        return File(imageDir, IMAGE_TEMP_FILE_NAME)
    }

    private fun getIntent(action: String): Intent {
        return Intent(action)
    }
}