package com.example.iyemon018.visionapiexample.viewModel

import android.arch.lifecycle.ViewModel
import android.net.Uri
import com.example.iyemon018.visionapiexample.useCase.MessageService
import com.example.iyemon018.visionapiexample.useCase.RequestService

/**
 * Created by iyemon018 on 2018/05/09.
 */

class MainActivityViewModel(private val messageService: MessageService, private val requestService: RequestService) : ViewModel() {

    var pictureUri: Uri? = null

    fun onClick() {
        this.requestService.toTakePicture()
    }

    fun onRequestFromCamera() {
        this.pictureUri = this.requestService.getPictureUri()
    }
}