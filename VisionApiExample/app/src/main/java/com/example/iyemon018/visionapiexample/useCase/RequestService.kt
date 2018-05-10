package com.example.iyemon018.visionapiexample.useCase

import android.net.Uri

/**
 * Created by iyemon018 on 2018/05/10.
 */
interface RequestService {
    fun toTakePicture()

    fun getPictureUri(): Uri
}